package com.example.library.domain.use_case

import android.content.Context
import com.example.library.R
import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.domain.model.RegistrationForm
import com.example.library.domain.model.UserForm

class RegistrationUseCase(
    private val applicationContext: Context,
    private val registrationRepositoryImpl: RegistrationRepositoryImpl
) {
    suspend fun execute(userForm: UserForm): String {

        if (userForm.userLogin == "" || userForm.userName == "" || userForm.userPassword == 0) {
            return applicationContext.getString(R.string.lib_empty_fields)
        }

        if (userForm.userPassword != userForm.reUserPassword) {
            return applicationContext.getString(R.string.lib_wrong_passwords)
        }

        if (!this.validatePhoneNumber(userForm.userLogin)) {
            return applicationContext.getString(R.string.lib_wrong_phone_number)
        }

        return registrationRepositoryImpl.signUp(userForm)
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        return true
    }
}