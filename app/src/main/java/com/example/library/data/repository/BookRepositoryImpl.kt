package com.example.library.data.repository

import com.example.library.data.mapper.BookMapper
import com.example.library.data.service.AppDatabase
import com.example.library.domain.model.Book
import com.example.library.domain.repository.IBookRepository

class BookRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val bookMapper: BookMapper
): IBookRepository {

    override fun getBooks(): List<Book>? {
        val list = appDatabase.bookDao().getBooks()?.map {
            bookMapper.mapToModel(it)
        }
        return  list
    }

    override suspend fun insertBooks(books: List<Book>) {
        appDatabase.bookDao().insertBooks(books.map {
            bookMapper.mapToEntity(it)
        })
    }

}