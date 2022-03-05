package com.example.library.domain.repository

import com.example.library.domain.model.RegistrationForm

interface IRegistrationRepository {
    fun checkRegistration(registrationForm: RegistrationForm): String
}