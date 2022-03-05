package com.example.library.domain.use_case

import com.example.library.data.repository.LoginRepositoryImpl

class LoginUseCase(
    private val userRepositoryImpl: LoginRepositoryImpl
) {
    fun executeCheckLogin(userLogin: String): Boolean {
        return userRepositoryImpl.checkLogin(
            userLogin = userLogin
        )
    }

    fun executeGetToken(userLogin: String, userPassword: String): String {
        return userRepositoryImpl.getToken(
            userLogin = userLogin,
            userPassword = userPassword
        )
    }
}