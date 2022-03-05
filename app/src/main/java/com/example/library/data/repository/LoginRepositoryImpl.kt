package com.example.library.data.repository

import com.example.library.data.service.DbServiceImpl
import com.example.library.domain.repository.ILoginRepository

class LoginRepositoryImpl(
    private val dbServiceImpl: DbServiceImpl
): ILoginRepository {
    override fun checkLogin(userLogin: String): Boolean {
        return dbServiceImpl.checkLogin(userLogin)
    }

    override fun getToken(userLogin: String, userPassword: String): String {
        return dbServiceImpl.getToken(userLogin = userLogin, userPassword = userPassword)
    }
}