package com.example.library.domain.service

import com.example.library.data.model.LibraryEntity
import com.example.library.data.model.BookNetwork

interface DbService {

    fun getLibraries(): List<LibraryEntity>

    fun checkLogin(userLogin: String): Boolean

    fun getToken(userLogin: String, userPassword: String): String

    fun createAccount(login: String, fullName: String, password: String): String

    fun getBooks(): ArrayList<BookNetwork>

    fun saveBook(): Boolean
}