package com.example.library.data.repository

import androidx.lifecycle.LiveData
import com.example.library.data.mapper.LibraryMapper
import com.example.library.data.service.AppDatabase
import com.example.library.domain.model.Library
import com.example.library.domain.repository.ILibrariesRepository

class LibrariesRepositoryImpl(
    private val appDatabase: AppDatabase,
    private val libraryMapper: LibraryMapper
): ILibrariesRepository {

    override fun getLibraries(): List<Library> {
        val list = appDatabase.libraryDao().getLibraries().map {
            libraryMapper.mapToModel(it)
        }
        return  list
    }

    override suspend fun addLibrary(library: Library) {
        appDatabase.libraryDao().addLibrary(libraryMapper.mapToEntity(library))
    }

    override suspend fun updateLibrary(library: Library) {
        appDatabase.libraryDao().updateLibrary(libraryMapper.mapToEntity(library))
    }
}