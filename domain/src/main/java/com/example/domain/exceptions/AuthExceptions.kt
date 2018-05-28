package com.example.domain.exceptions

class InvalidEmailException(override var message:String): Exception(message)
class InvalidPasswordException(override var message:String): Exception(message)
class NoAgreementCheckedException(override var message:String): Exception(message)
class LoginFailedException(override var message:String): Exception(message)