package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.library.domain.model.LoginForm
import com.example.library.domain.use_case.LoginUseCase
import java.util.*

class LoginViewModel(
    private val useCase: LoginUseCase
): ViewModel() {

    private var token: MutableLiveData<String> = MutableLiveData("")
    private var actionDirections: MutableLiveData<NavDirections> = MutableLiveData(null)
    private var wrongText: MutableLiveData<String> = MutableLiveData("")

    fun getActionDirections() = actionDirections
    fun getToken() = token
    fun wrongText() = wrongText

    fun logIn(user: LoginForm) {
        val response = useCase.logIn(user)
        when(response.lowercase(Locale.getDefault())) {
            "user not found", "invalid username or password" -> wrongText.value = response
            else -> token.value = response
        }
    }

    fun saveToken() {
        actionDirections.value = useCase.saveToken(this.token.value)
    }


}