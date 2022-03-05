package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library.domain.model.Library
import com.example.library.domain.use_case.LibrariesUseCase

class SplashScreenViewModel(private val getLibraries: LibrariesUseCase): ViewModel() {

    private var libraries: MutableLiveData<List<Library>> = MutableLiveData();
    private var selectedLibrary: MutableLiveData<Library> = MutableLiveData();

    fun getLibraries() = libraries

    fun setLibraries() {
        libraries.value = getLibraries.execute()
    }

    fun selectLibrary(library: Library) {
        selectedLibrary.value = library
    }

    fun getSelectedLibrary() = selectedLibrary


}