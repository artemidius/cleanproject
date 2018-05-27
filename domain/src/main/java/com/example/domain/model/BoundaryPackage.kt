package com.example.domain.model

import com.example.domain.interactors.Interactor

data class InteractionPackage(
        val backend: Interactor.Backend,
        val presenter: Interactor.LoginPresenter
)