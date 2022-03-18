package com.example.library.domain.repository

import com.example.library.domain.model.LoginForm

interface ILoginRepository {

    fun logIn(user: LoginForm): String

}