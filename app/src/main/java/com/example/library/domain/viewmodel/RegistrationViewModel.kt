package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.library.domain.model.UserForm
import com.example.library.domain.use_case.RegistrationUseCase
import com.example.library.presentation.activity.registration.RegistrationFragmentDirections

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {

    private var actionDirections: MutableLiveData<NavDirections> = MutableLiveData(null)
    private var wrongText: MutableLiveData<String> = MutableLiveData("")

    fun getActionDirections() = this.actionDirections
    fun wrongText() = this.wrongText

    suspend fun signUp(user: UserForm) {
        val response = registrationUseCase.execute(userForm = user)
        if (response == "") {
            actionDirections.postValue(RegistrationFragmentDirections.actionRegistrationFragmentToLoginFragment())
        } else {
            wrongText.postValue(response)
        }
    }
}