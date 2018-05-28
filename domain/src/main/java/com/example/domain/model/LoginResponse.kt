package com.example.domain.model

class LoginResponse (
        val status: Int,
        val token: String?,
        val errorMessage: String?
)