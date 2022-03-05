package com.example.library.data.repository

import com.example.library.data.service.DbServiceImpl
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.repository.ILoginRepository
import com.example.library.domain.repository.IRegistrationRepository

class RegistrationRepositoryImpl(
    private val dbServiceImpl: DbServiceImpl
): IRegistrationRepository {
    override fun checkRegistration(registrationForm: RegistrationForm): String {
        return dbServiceImpl.createAccount(
            registrationForm.fullName,
            registrationForm.login,
            registrationForm.password
        )
    }

}