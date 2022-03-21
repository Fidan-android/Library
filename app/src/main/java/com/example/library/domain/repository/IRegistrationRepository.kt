package com.example.library.domain.repository

import com.example.library.domain.model.UserForm

interface IRegistrationRepository {
    suspend fun signUp(userForm: UserForm): String
}