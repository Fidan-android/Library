package com.example.library.domain.di.repository_modules

import com.example.library.data.mapper.LibraryMapper
import com.example.library.data.mapper.UserMapper
import com.example.library.data.repository.BookRepositoryImpl
import com.example.library.data.repository.LibrariesRepositoryImpl
import com.example.library.data.repository.LoginRepositoryImpl
import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.data.service.AppDatabase
import com.example.library.data.service.DbServiceImpl

class RepositoryModule() {

    fun getLibrariesRepository(appDatabase: AppDatabase, libraryMapper: LibraryMapper): LibrariesRepositoryImpl =
        LibrariesRepositoryImpl(appDatabase, libraryMapper)

    fun getLoginRepository(appDatabase: AppDatabase, loginMapper: UserMapper): LoginRepositoryImpl =
        LoginRepositoryImpl(appDatabase, loginMapper)

    fun getRegistrationRepository(appDatabase: AppDatabase, loginMapper: UserMapper):
            RegistrationRepositoryImpl = RegistrationRepositoryImpl(appDatabase, loginMapper)

    fun getBookRepository(dbServiceImpl: DbServiceImpl):
            BookRepositoryImpl = BookRepositoryImpl(dbServiceImpl)
}