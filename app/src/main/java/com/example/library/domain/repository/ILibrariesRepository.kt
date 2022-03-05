package com.example.library.domain.repository

import com.example.library.domain.model.Library

interface ILibrariesRepository {

    fun getLibraries(): List<Library>
}