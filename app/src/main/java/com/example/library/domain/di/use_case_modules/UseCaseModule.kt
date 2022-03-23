package com.example.library.domain.di.use_case_modules

import android.content.Context
import com.example.library.data.repository.*
import com.example.library.domain.use_case.BookUseCase
import com.example.library.domain.use_case.LoginUseCase
import com.example.library.domain.use_case.SplashScreenUseCase
import com.example.library.domain.use_case.RegistrationUseCase

class UseCaseModule {
    fun librariesUseCase(applicationContext: Context, getLibrariesRepositoryImpl: LibrariesRepositoryImpl):
            SplashScreenUseCase = SplashScreenUseCase(applicationContext, getLibrariesRepositoryImpl)

    fun loginUseCase(applicationContext: Context, userRepositoryImpl: LoginRepositoryImpl):
            LoginUseCase = LoginUseCase(applicationContext, userRepositoryImpl)

    fun registrationUseCase(applicationContext: Context, registrationRepositoryImpl: RegistrationRepositoryImpl):
            RegistrationUseCase = RegistrationUseCase(applicationContext, registrationRepositoryImpl)

    fun bookUseCase(applicationContext: Context, bookRepositoryImpl: BookRepositoryImpl, apiRepositoryImpl: ApiRepositoryImpl):
            BookUseCase = BookUseCase(applicationContext, bookRepositoryImpl, apiRepositoryImpl)
}