package com.example.library.domain.repository

import com.example.library.domain.model.Book

interface IBookRepository {

    fun getBooks(): List<Book>?

    suspend fun insertBooks(books: List<Book>)
}