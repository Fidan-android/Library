package com.example.library.domain.service

import com.example.library.GlobalApplication
import com.example.library.data.model.Library
import com.example.library.data.service.TypeJsonString
import com.example.library.domain.model.Book

interface DbService {

    fun getLibraries(): List<Library>

    fun checkLogin(userLogin: String): Boolean

    fun getToken(userLogin: String, userPassword: String): String

    fun createAccount(login: String, fullName: String, password: String): String

    fun getBooks(): ArrayList<Book>

    fun saveBook(): Boolean
}