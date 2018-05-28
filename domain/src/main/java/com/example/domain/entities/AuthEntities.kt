package com.example.domain.entities

import com.example.domain.exceptions.InvalidEmailException
import com.example.domain.exceptions.InvalidPasswordException
import com.example.domain.exceptions.LoginFailedException
import com.example.domain.exceptions.NoAgreementCheckedException
import com.example.domain.model.LoginResponse
import com.example.domain.model.LoginScreenViewModel

class AuthEntities {

    @Throws
    fun inputIsCorrect(model: LoginScreenViewModel) {
        if (model.emailInputText.length < 6 || !model.emailInputText.contains('@'))
            throw InvalidEmailException("Invalid Email")
        else if (model.passwordInputText.length == 0)
            throw InvalidPasswordException("Invalid Password")
        else if (!model.agreementAccepted)
            throw NoAgreementCheckedException("No agreement was checked")
    }

    @Throws()
    fun handleLoginResponse(response: LoginResponse):Boolean {
        if (response.status == 200 && response.token != null) return true
        else return false
    }

}