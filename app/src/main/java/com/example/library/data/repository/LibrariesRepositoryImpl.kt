package com.example.library.data.repository

import com.example.library.data.service.DbServiceImpl
import com.example.library.domain.model.Library
import com.example.library.domain.repository.ILibrariesRepository

class LibrariesRepositoryImpl(
    private val dbServiceImpl: DbServiceImpl
): ILibrariesRepository {

    // еще не трогал мапперы, наверно их опять передавать в конструктор,
    // но как интересно в мапперах создавать модельки из домейн слоя
    override fun getLibraries(): List<Library> {
        val list = dbServiceImpl.getLibraries().map {
            Library(
                id = it.id,
                name = it.name
            )
        }
        return list
    }
}