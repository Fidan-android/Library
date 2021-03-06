package com.example.library.domain.model

data class Book(
    val id: Int = 0,
    val title: String,
    val subtitle: String?,
    val author: String,
    val published: String,
    val pages: Int,
    val description: String
)
