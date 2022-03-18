package com.example.library.domain.di.mapper_modules

import com.example.library.data.mapper.LibraryMapper
import com.example.library.data.mapper.LoginMapper
import com.example.library.data.repository.BookRepositoryImpl
import com.example.library.data.repository.LibrariesRepositoryImpl
import com.example.library.data.repository.LoginRepositoryImpl
import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.data.service.AppDatabase
import com.example.library.data.service.DbServiceImpl

class MapperModule() {
    companion object {
        fun getLibraryMapper(): LibraryMapper = LibraryMapper()

        fun getLoginMapper(): LoginMapper = LoginMapper()
    }
}