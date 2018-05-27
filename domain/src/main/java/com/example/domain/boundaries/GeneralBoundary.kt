package com.example.domain.interactors

import com.example.domain.model.LoginResponse
import io.reactivex.Single

interface Interactor {

    interface LoginPresenter {
        fun onLoginSuccess()
        fun onLoginFail()
        fun onInvalidEmail()
        fun onInvalidPassword()
        fun onNoAgreement()
    }

    interface Backend {
        fun attemptLogin(login:String, password:String): Single<LoginResponse>
    }
}