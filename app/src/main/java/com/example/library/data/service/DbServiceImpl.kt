package com.example.library.data.service

import android.content.Context
import android.util.Log
import com.example.library.data.model.LibraryEntity
import com.example.library.data.model.Book
import com.example.library.domain.service.DbService
import com.google.gson.Gson

class DbServiceImpl(private val applicationContext: Context): DbService {

    private val gson: Gson by lazy {
        Gson()
    }

    private val librariesString: String by lazy {
        ConnectService.getJsonFromAssets(applicationContext, NameOfFiles.libraries)
    }

    private val booksString: String by lazy {
        ConnectService.getJsonFromAssets(applicationContext, NameOfFiles.books)
    }

    private val accountsString: String by lazy {
        ConnectService.getJsonFromInternalStorage(applicationContext, NameOfFiles.accounts)
    }

    private val tokensString: String by lazy {
        ConnectService.getJsonFromInternalStorage(applicationContext, NameOfFiles.tokens)
    }

    override fun getLibraries(): List<LibraryEntity> {
        return gson.fromJson(librariesString, TypeJsonString.listLibraryType)
    }

    override fun checkLogin(userLogin: String): Boolean {
//        if (accountsString == "") return false
//        val userList: MutableList<User?>? = gson.fromJson(accountsString, TypeJsonString.listAccountsType)
//        userList?.forEach {
//            Log.d("LOGIN", it?.userLogin + " | " + it?.userName)
//        }
//        val user = userList?.find {
//            userLogin == it?.userLogin
//        }

        return true
    }

    override fun getToken(userLogin: String, userPassword: String): String {
//        val user = gson.fromJson<List<User>?>(accountsString, TypeJsonString.listAccountsType).find {
//            userLogin == it.userLogin
//        }
//
//        return if (user!!.hashPassword == userPassword.hashCode()) {
//            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
//            val randomString = (1..25)
//                .map {
//                    allowedChars.random()
//                }
//                .joinToString("")
//
//            val tokens: MutableList<Token> = gson.fromJson(tokensString, TypeJsonString.listTokensType)
//            tokens.add(Token(user.userLogin,randomString))
//            ConnectService.saveJsonToInternalStorage(applicationContext, gson.toJson(tokens), NameOfFiles.tokens)
//            randomString
//        } else {
//            ""
//        }
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        val randomString = (1..25)
            .map {
                allowedChars.random()
            }
            .joinToString("")
        Log.d("TOKEN", randomString)
        return randomString
    }

    override fun createAccount(login: String, fullName: String, password: String): String {
//        val userList: MutableList<User?>? = gson.fromJson(accountsString, TypeJsonString.listAccountsType)
//        val user = userList?.find{
//            it?.userLogin == login
//        }
//
//        if (user == null) {
//            userList?.add(User(
//                userName = fullName,
//                userLogin = login,
//                hashPassword = password.hashCode()
//            ))
//            userList?.forEach {
//                Log.d("REGISTRATION", it?.userLogin + " | " + it?.userName)
//            }
//            ConnectService.saveJsonToInternalStorage(applicationContext, gson.toJson(userList), NameOfFiles.accounts)
//            return "success"
//        }
        return "success"
    }

    override fun getBooks(): ArrayList<Book> = gson.fromJson(booksString, TypeJsonString.listBooksType)

    override fun saveBook(): Boolean {
        return true
    }

}