package com.example.library.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val subtitle: String?,
    val author: String,
    val published: String,
    val pages: Int,
    val description: String
)
