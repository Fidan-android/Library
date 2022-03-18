package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.library.domain.model.Library
import com.example.library.domain.use_case.SplashScreenUseCase

class SplashScreenViewModel(private val useCase: SplashScreenUseCase): ViewModel() {

    private var libraries: MutableLiveData<List<Library>> = MutableLiveData()
    private var selectedLibrary: MutableLiveData<Library?> = MutableLiveData()
    private var stringToken: MutableLiveData<String> = MutableLiveData("")
    private var actionDirections: MutableLiveData<NavDirections> = MutableLiveData(null)

    init {
        libraries.value = useCase.requestOfLibraries()
        selectedLibrary.value = libraries.value!!.find {
            it.id == useCase.requestOfDataInt("id_library", -1)
        }
        stringToken.value = useCase.requestOfDataString("token", "")
    }

    fun getLibraries() = libraries
    fun getSelectedLibrary() = selectedLibrary
    fun getActionDirections() = actionDirections

    fun checkToken() {
        actionDirections.value = useCase.checkedToken(this.stringToken.value!!)
    }
    fun selectLibrary(library: Library) {
        selectedLibrary.value = library
        useCase.selectLibrary(library)
    }



}