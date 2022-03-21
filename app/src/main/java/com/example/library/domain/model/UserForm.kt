package com.example.library.domain.model

data class UserForm(
    val id: Int = 0,
    val userLogin: String,
    val userName: String = "",
    val userPassword: Int,
    val reUserPassword: Int = 0
)
