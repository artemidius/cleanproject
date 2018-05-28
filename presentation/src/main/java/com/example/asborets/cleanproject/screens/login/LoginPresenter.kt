package com.example.asborets.cleanproject.screens.login

import com.example.data.BackendRepository
import com.example.domain.boundaries.GeneralBoundary
import com.example.domain.model.BoundaryPackage
import com.example.domain.model.LoginScreenViewModel
import com.example.domain.usecases.loginattempt.LoginAttemptUseCase
import com.example.domain.usecases.loginattempt.LoginAttemptInteractor

class LoginPresenter : LoginContract.Presenter, GeneralBoundary.LoginPresenter {

    var activity:LoginActivity? = null
    val loginAttemptUseCase:LoginAttemptUseCase = LoginAttemptInteractor()
    val backendGeneralBoundary:GeneralBoundary.Backend = BackendRepository()
    val presenterGeneralBoundary:GeneralBoundary.LoginPresenter = this
    val boundaryPackage = BoundaryPackage(backendGeneralBoundary, presenterGeneralBoundary)
    var screen:LoginContract.Screen? = null

    override fun onCreate(loginActivity: LoginActivity) {
        activity = loginActivity
        screen = activity
    }

    override fun onLoginButtonPressed(model: LoginScreenViewModel) {
        screen?.deactivateLoginButton(true)
        loginAttemptUseCase.run(model, boundaryPackage)
    }

    override fun onInvalidEmail() {
        screen?.deactivateLoginButton(false)
        screen?.showSnack("Invalid Email")
    }

    override fun onInvalidPassword() {
        screen?.deactivateLoginButton(false)
        screen?.showSnack("Invalid Password")
    }

    override fun onNoAgreement() {
        screen?.deactivateLoginButton(false)
        screen?.showSnack("Please accept agreement")
    }

    override fun onLoginSuccess() {
        screen?.deactivateLoginButton(false)
        screen?.showSnack("Login Success")
    }

    override fun onLoginFail() {
        screen?.deactivateLoginButton(false)
        screen?.showSnack("Access Denied")
    }

}