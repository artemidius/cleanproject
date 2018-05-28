package com.example.data

import com.example.domain.boundaries.GeneralBoundary
import com.example.domain.model.LoginResponse
import io.reactivex.Single

class BackendRepository:GeneralBoundary.Backend {

    val httpService = HttpService()

    override fun attemptLogin(login: String, password: String): Single<LoginResponse> =
            Single.create {emitter ->
                emitter.onSuccess(httpService.login(login, password))
            }

}