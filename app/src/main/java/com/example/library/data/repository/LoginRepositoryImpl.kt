package com.example.library.data.repository

import android.util.Log
import com.example.library.data.mapper.UserMapper
import com.example.library.data.service.AppDatabase
import com.example.library.domain.model.UserForm
import com.example.library.domain.repository.ILoginRepository

class LoginRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val loginMapper: UserMapper
): ILoginRepository {

    override fun logIn(user: UserForm): String {
        Log.d("USERS", user.userLogin)
        val response = appDatabase.userDao().logIn(loginMapper.mapToEntity(user).userLogin)
        return if (response != null) {
            if (response.hashPassword != user.userPassword) {
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
        } else {
            "User not found"
        }
    }
}