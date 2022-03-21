package com.example.library.domain.repository

import com.example.library.domain.model.UserForm

interface ILoginRepository {

    fun logIn(user: UserForm): String

}