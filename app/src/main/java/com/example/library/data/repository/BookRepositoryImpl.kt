package com.example.library.data.repository

import com.example.library.data.service.DbServiceImpl
import com.example.library.domain.model.Book
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.repository.IBookRepository
import com.example.library.domain.repository.ILoginRepository
import com.example.library.domain.repository.IRegistrationRepository

class BookRepositoryImpl(
    private val dbServiceImpl: DbServiceImpl
): IBookRepository {
    override fun getBooks(): ArrayList<Book> {
        return dbServiceImpl.getBooks()
    }

}