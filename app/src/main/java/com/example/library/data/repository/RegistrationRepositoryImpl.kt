package com.example.library.data.repository

import com.example.library.data.mapper.UserMapper
import com.example.library.data.service.AppDatabase
import com.example.library.data.service.DbServiceImpl
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.model.UserForm
import com.example.library.domain.repository.ILoginRepository
import com.example.library.domain.repository.IRegistrationRepository

class RegistrationRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val loginMapper: UserMapper
): IRegistrationRepository {

    override fun signUp(userForm: UserForm): String {
        return ""
    }
}