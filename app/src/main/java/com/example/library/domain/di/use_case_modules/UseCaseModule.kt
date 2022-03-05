package com.example.library.domain.di.use_case_modules

import com.example.library.data.repository.BookRepositoryImpl
import com.example.library.data.repository.LibrariesRepositoryImpl
import com.example.library.data.repository.LoginRepositoryImpl
import com.example.library.data.repository.RegistrationRepositoryImpl
import com.example.library.domain.use_case.BookUseCase
import com.example.library.domain.use_case.LoginUseCase
import com.example.library.domain.use_case.LibrariesUseCase
import com.example.library.domain.use_case.RegistrationUseCase

class UseCaseModule {
    fun librariesUseCase(getLibrariesRepositoryImpl: LibrariesRepositoryImpl):
            LibrariesUseCase = LibrariesUseCase(getLibrariesRepositoryImpl)

    fun checkLoginUseCase(userRepositoryImpl: LoginRepositoryImpl):
            LoginUseCase = LoginUseCase(userRepositoryImpl)

    fun registrationUseCase(registrationRepositoryImpl: RegistrationRepositoryImpl):
            RegistrationUseCase = RegistrationUseCase(registrationRepositoryImpl)

    fun bookUseCase(bookRepositoryImpl: BookRepositoryImpl):
            BookUseCase = BookUseCase(bookRepositoryImpl)
}