package com.example.domain.boundaries

import com.example.domain.model.LoginResponse
import io.reactivex.Single

interface GeneralBoundary {

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