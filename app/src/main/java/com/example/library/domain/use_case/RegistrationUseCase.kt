package com.example.library.domain.use_case

import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.domain.model.RegistrationForm

class RegistrationUseCase(
    private val registrationRepositoryImpl: RegistrationRepositoryImpl
) {
    fun execute(registrationForm: RegistrationForm): String {
        return registrationRepositoryImpl.checkRegistration(registrationForm = registrationForm)
    }

    fun validatePhoneNumber(phoneNumber: String): Boolean {
        return true
    }
}