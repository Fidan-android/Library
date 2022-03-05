package com.example.library.domain.di.repository_modules

import com.example.library.data.repository.BookRepositoryImpl
import com.example.library.data.repository.LibrariesRepositoryImpl
import com.example.library.data.repository.LoginRepositoryImpl
import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.data.service.DbServiceImpl

class RepositoryModule() {

    fun getLibrariesRepository(dbServiceImpl: DbServiceImpl): LibrariesRepositoryImpl =
        LibrariesRepositoryImpl(dbServiceImpl)

    fun getLoginRepository(dbServiceImpl: DbServiceImpl): LoginRepositoryImpl =
        LoginRepositoryImpl(dbServiceImpl)

    fun getRegistrationRepository(dbServiceImpl: DbServiceImpl):
            RegistrationRepositoryImpl = RegistrationRepositoryImpl(dbServiceImpl)

    fun getBookRepository(dbServiceImpl: DbServiceImpl):
            BookRepositoryImpl = BookRepositoryImpl(dbServiceImpl)
}