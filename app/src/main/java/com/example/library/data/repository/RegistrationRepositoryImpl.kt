package com.example.library.data.repository

import com.example.library.data.mapper.UserMapper
import com.example.library.data.service.AppDatabase
import com.example.library.domain.model.UserForm
import com.example.library.domain.repository.IRegistrationRepository

class RegistrationRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val loginMapper: UserMapper
): IRegistrationRepository {

    override suspend fun signUp(userForm: UserForm): String {
        return if (appDatabase.userDao().logIn(loginMapper.mapToEntity(userForm).userLogin) == null) {
            appDatabase.userDao().sigUp(loginMapper.mapToEntity(userForm))
            ""
        } else {
            "The user has already been created"
        }
    }
}