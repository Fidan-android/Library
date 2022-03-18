package com.example.library.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userName: String,
    val userLogin: String,
    val hashPassword: Int
)
