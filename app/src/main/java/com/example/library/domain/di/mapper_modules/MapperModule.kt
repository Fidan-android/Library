package com.example.library.domain.di.mapper_modules

import com.example.library.data.mapper.ApiMapper
import com.example.library.data.mapper.BookMapper
import com.example.library.data.mapper.LibraryMapper
import com.example.library.data.mapper.UserMapper

class MapperModule() {
    companion object {
        fun getLibraryMapper(): LibraryMapper = LibraryMapper()
        fun getLoginMapper(): UserMapper = UserMapper()
        fun getBookMapper(): BookMapper = BookMapper()
        fun getApiMapper(): ApiMapper = ApiMapper()
    }
}