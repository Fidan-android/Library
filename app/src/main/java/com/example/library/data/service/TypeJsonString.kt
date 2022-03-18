package com.example.library.data.service

import com.example.library.data.model.Book
import com.example.library.data.model.LibraryEntity
import com.example.library.data.model.Token
import com.example.library.data.model.UserEntity
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object TypeJsonString {
    val listLibraryType: Type = object: TypeToken<List<LibraryEntity>>() {}.type
    val listBooksType: Type = object: TypeToken<ArrayList<Book>>() {}.type
    val listMyBooksType: Type = object: TypeToken<List<LibraryEntity>>() {}.type
    val listAccountsType: Type = object: TypeToken<List<UserEntity>>() {}.type
    val listTokensType: Type = object: TypeToken<List<Token>>() {}.type
}