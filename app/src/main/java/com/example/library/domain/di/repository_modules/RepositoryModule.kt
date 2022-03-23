package com.example.library.domain.di.repository_modules

import com.example.library.data.mapper.ApiMapper
import com.example.library.data.mapper.BookMapper
import com.example.library.data.mapper.LibraryMapper
import com.example.library.data.mapper.UserMapper
import com.example.library.data.repository.*
import com.example.library.data.service.AppDatabase
import com.example.library.data.service.api.ApiHelper

class RepositoryModule() {

    fun getLibrariesRepository(appDatabase: AppDatabase, libraryMapper: LibraryMapper): LibrariesRepositoryImpl =
        LibrariesRepositoryImpl(appDatabase, libraryMapper)

    fun getLoginRepository(appDatabase: AppDatabase, loginMapper: UserMapper): LoginRepositoryImpl =
        LoginRepositoryImpl(appDatabase, loginMapper)

    fun getRegistrationRepository(appDatabase: AppDatabase, loginMapper: UserMapper):
            RegistrationRepositoryImpl = RegistrationRepositoryImpl(appDatabase, loginMapper)

    fun getBookRepository(appDatabase: AppDatabase, bookMapper: BookMapper):
            BookRepositoryImpl = BookRepositoryImpl(appDatabase, bookMapper)

    fun getApiRepository(apiHelper: ApiHelper, apiMapper: ApiMapper):
            ApiRepositoryImpl = ApiRepositoryImpl(apiHelper, apiMapper)
}