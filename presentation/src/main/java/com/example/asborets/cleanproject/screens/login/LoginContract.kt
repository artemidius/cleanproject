package com.example.asborets.cleanproject.screens.login

import com.example.domain.model.LoginScreenViewModel

interface LoginContract {

    interface Presenter {
        fun onCreate(loginActivity: LoginActivity)
        fun onLoginButtonPressed(model:LoginScreenViewModel)

    }

    interface Screen {
        fun showSnack(message:String)
        fun deactivateLoginButton(state:Boolean)

    }

}