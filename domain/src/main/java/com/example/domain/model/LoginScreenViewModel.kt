package com.example.domain.model

data class LoginScreenViewModel (
        val emailInputText:String,
        val passwordInputText:String,
        val agreementAccepted:Boolean,
        val sendMeLettersAlowed:Boolean
)