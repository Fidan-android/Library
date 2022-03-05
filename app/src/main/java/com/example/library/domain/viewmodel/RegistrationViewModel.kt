package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.use_case.RegistrationUseCase

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {

    private var statusRegistration: MutableLiveData<String> = MutableLiveData("")
    private var statusValidate: MutableLiveData<Int> = MutableLiveData(0)

    fun getIsRegistration() = this.statusRegistration
    fun getStatusValidate() = this.statusValidate

    fun signUp(registrationForm: RegistrationForm) {
        statusRegistration.value = registrationUseCase.execute(registrationForm = registrationForm)
    }

    fun validatePhone(phoneNumber: String) {
        statusValidate.value = if (registrationUseCase.validatePhoneNumber(
                phoneNumber = phoneNumber
            )) -1 else 0
    }
}