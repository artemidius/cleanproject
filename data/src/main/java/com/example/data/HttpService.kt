package com.example.data

import com.example.domain.model.LoginResponse

class HttpService {
    fun login(login:String, password:String):LoginResponse {
        Thread.sleep(3000)
        if (login == "a@a.ru" && password == "admin")
            return LoginResponse(
                status = 200,
                token = "jhkhkjhgkjghkjg",
                errorMessage = null
            )
        else
            return LoginResponse(
                    status = 403,
                    token = null,
                    errorMessage = "Access denied"
            )
    }
}