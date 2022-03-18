package com.example.library.data.repository

import com.example.library.data.mapper.LoginMapper
import com.example.library.data.service.AppDatabase
import com.example.library.domain.model.LoginForm
import com.example.library.domain.repository.ILoginRepository

class LoginRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val loginMapper: LoginMapper
): ILoginRepository {

    override fun logIn(user: LoginForm): String {
        val response = appDatabase.userDao().logIn(loginMapper.mapToEntity(user).userLogin) ?: return "User not found"
        return if (response.hashPassword != user.userPassword) {
            "Invalid username or password"
        } else {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            val randomString = (1..25)
                .map {
                    allowedChars.random()
                }
                .joinToString("")
            randomString
        }
    }
}