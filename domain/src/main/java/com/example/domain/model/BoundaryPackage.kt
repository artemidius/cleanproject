package com.example.domain.model

import com.example.domain.boundaries.GeneralBoundary

data class BoundaryPackage(
        val backend: GeneralBoundary.Backend,
        val presenter: GeneralBoundary.LoginPresenter
)