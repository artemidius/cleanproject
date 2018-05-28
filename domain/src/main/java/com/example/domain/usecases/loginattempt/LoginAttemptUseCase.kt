package com.example.domain.usecases.loginattempt

import com.example.domain.model.BoundaryPackage
import com.example.domain.model.LoginScreenViewModel

interface LoginAttemptUseCase{
    fun run(model:LoginScreenViewModel, interactionPackage: BoundaryPackage)
}

