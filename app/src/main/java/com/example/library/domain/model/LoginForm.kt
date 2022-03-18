package com.example.library.domain.model

data class LoginForm(
    val id: Int = 0,
    val userLogin: String,
    val userName: String = "",
    val userPassword: Int
)
