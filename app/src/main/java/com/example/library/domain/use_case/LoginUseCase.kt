package com.example.library.domain.use_case

import android.content.Context
import androidx.navigation.NavDirections
import com.example.library.R
import com.example.library.data.repository.LoginRepositoryImpl
import com.example.library.domain.model.UserForm
import com.example.library.presentation.activity.login.LoginFragmentDirections

class LoginUseCase(private val applicationContext: Context,
                   private val userRepositoryImpl: LoginRepositoryImpl
) {

    fun logIn(user: UserForm): String {
        return userRepositoryImpl.logIn(
            user = user
        )
    }

    fun saveToken(stringToken: String?): NavDirections {
        val editor = applicationContext.getSharedPreferences(applicationContext.getString(R.string.app_name), 0).edit()
        editor.putString("token", stringToken)
        editor.apply()
        return LoginFragmentDirections.actionLoginFragmentToBookListFragment()
    }
}