package com.example.library.domain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library.domain.model.LoginForm
import com.example.library.domain.use_case.LoginUseCase

class LoginViewModel(
    private val userUseCase: LoginUseCase
): ViewModel() {

    private var isLogin: MutableLiveData<Boolean> = MutableLiveData(false)
    private var token: MutableLiveData<String> = MutableLiveData("")

    fun getIsLogin() = isLogin
    fun getToken() = token

    fun checkLogin(user: LoginForm) {
        if (userUseCase.executeCheckLogin(user.userLogin)) {
            isLogin.value = true
            token.value = userUseCase.executeGetToken(user.userLogin, user.userPassword)
        } else {
            isLogin.value = false
        }
    }
}