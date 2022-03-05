package com.example.library.domain.use_case

import com.example.library.data.repository.LibrariesRepositoryImpl
import com.example.library.domain.model.Library

class LibrariesUseCase(private val getLibrariesRepositoryImpl: LibrariesRepositoryImpl) {

    fun execute(): List<Library> {
        return getLibrariesRepositoryImpl.getLibraries()
    }
}