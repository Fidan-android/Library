package com.example.library.domain.model

data class Book(
    val isbn: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val published: String,
    val publisher: String,
    val pages: Int,
    val description: String,
    val website: String
)
