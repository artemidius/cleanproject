package com.example.domain.usecases.loginattempt

import com.example.domain.entities.AuthEntities
import com.example.domain.exceptions.InvalidEmailException
import com.example.domain.exceptions.InvalidPasswordException
import com.example.domain.exceptions.NoAgreementCheckedException
import com.example.domain.model.BoundaryPackage
import com.example.domain.model.LoginResponse
import com.example.domain.model.LoginScreenViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginAttemptInteractor : LoginAttemptUseCase {
    override fun run(model: LoginScreenViewModel, interactionPackage: BoundaryPackage) {

        val (backend, presenter) = interactionPackage
        val (email, password) = model

        try {
            AuthEntities().inputIsCorrect(model)

            backend.attemptLogin(email, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { response: LoginResponse ->
                        AuthEntities().handleLoginResponse(response)
                    }
                    .subscribe { loginSuccessful: Boolean ->
                        if(loginSuccessful) presenter.onLoginSuccess()
                        else presenter.onLoginFail()
                    }

        }
        catch (e: Throwable) {
            when (e) {
                is InvalidEmailException -> presenter.onInvalidEmail()
                is InvalidPasswordException -> presenter.onInvalidPassword()
                is NoAgreementCheckedException -> presenter.onNoAgreement()
            }
        }
    }
}


