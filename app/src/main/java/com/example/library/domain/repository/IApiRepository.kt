package com.example.library.domain.repository

import com.example.library.domain.model.Book

interface IApiRepository {
    suspend fun getBooks(): List<Book>
}