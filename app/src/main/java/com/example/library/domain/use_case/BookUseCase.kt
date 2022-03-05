package com.example.library.domain.use_case

import com.example.library.data.repository.BookRepositoryImpl
import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.domain.model.Book
import com.example.library.domain.model.RegistrationForm

class BookUseCase(private val bookRepositoryImpl: BookRepositoryImpl) {

    fun execute(): ArrayList<Book> = bookRepositoryImpl.getBooks()

}