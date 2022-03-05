package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library.domain.model.Book
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.use_case.BookUseCase
import com.example.library.domain.use_case.RegistrationUseCase

class BooksViewModel(
    private val bookUseCase: BookUseCase
): ViewModel() {

    private var books: MutableLiveData<ArrayList<Book>> = MutableLiveData()

    fun getBooks() = books

    fun downloadBooks() {
        books.value = bookUseCase.execute()
    }
}