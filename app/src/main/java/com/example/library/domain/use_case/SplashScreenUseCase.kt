package com.example.library.domain.use_case

import android.content.Context
import androidx.navigation.NavDirections
import com.example.library.R
import com.example.library.data.repository.LibrariesRepositoryImpl
import com.example.library.domain.model.Library
import com.example.library.presentation.activity.splash.SplashFragmentDirections

class SplashScreenUseCase(private val applicationContext: Context,
                          private val getLibrariesRepositoryImpl: LibrariesRepositoryImpl) {

    fun requestOfLibraries(): List<Library> {
        return getLibrariesRepositoryImpl.getLibraries()
    }

    fun requestOfDataInt(identifier: String, defaultValue: Int): Int {
        return applicationContext.getSharedPreferences(
            applicationContext.getString(R.string.app_name), 0).getInt(identifier, defaultValue)
    }

    fun requestOfDataString(identifier: String, defaultValue: String): String {
        return applicationContext.getSharedPreferences(
            applicationContext.getString(R.string.app_name), 0).getString(identifier, defaultValue)!!
    }

    fun selectLibrary(library: Library) {
        val ed = applicationContext.getSharedPreferences(applicationContext.getString(
            R.string.app_name), 0).edit()
        ed.putInt("id_library", library.id)
        ed.apply()
    }

    fun checkedToken(stringToken: String): NavDirections {
        return if (stringToken == "") {
            SplashFragmentDirections.actionSplashFragmentToLoginFragment()
        } else {
            SplashFragmentDirections.actionSplashFragmentToBookListFragment()
        }
    }
}