package com.example.library.domain.repository

import androidx.lifecycle.LiveData
import com.example.library.domain.model.Library

interface ILibrariesRepository {

    fun getLibraries(): List<Library>

    suspend fun addLibrary(library: Library)

    suspend fun updateLibrary(library: Library)
}