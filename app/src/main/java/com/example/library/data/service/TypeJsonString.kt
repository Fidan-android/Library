package com.example.library.data.service

import com.example.library.data.model.Book
import com.example.library.data.model.Library
import com.example.library.data.model.Token
import com.example.library.data.model.User
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object TypeJsonString {
    val listLibraryType: Type = object: TypeToken<List<Library>>() {}.type
    val listBooksType: Type = object: TypeToken<ArrayList<Book>>() {}.type
    val listMyBooksType: Type = object: TypeToken<List<Library>>() {}.type
    val listAccountsType: Type = object: TypeToken<List<User>>() {}.type
    val listTokensType: Type = object: TypeToken<List<Token>>() {}.type
}