package com.example.library.domain.repository

import com.example.library.domain.model.UserForm

interface IRegistrationRepository {
    fun signUp(userForm: UserForm): String
}