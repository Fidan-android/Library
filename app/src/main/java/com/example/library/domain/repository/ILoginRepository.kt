package com.example.library.domain.repository

interface ILoginRepository {

    fun checkLogin(userLogin: String): Boolean

    fun getToken(userLogin: String, userPassword: String): String

}