package com.example.library.data.model

data class BookNetwork(
    val id: Int = 0,
    val title: String,
    val subtitle: String?,
    val author: String,
    val published: String,
    val pages: Int,
    val description: String
)
