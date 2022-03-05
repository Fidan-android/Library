package com.example.library.domain.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.viewmodel.BooksViewModel
import com.example.library.domain.viewmodel.LoginViewModel
import com.example.library.domain.viewmodel.RegistrationViewModel
import com.example.library.domain.viewmodel.SplashScreenViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class LibraryViewModelFactory(
    private val useCaseModule: UseCaseModule,
    private val repositoryModule: RepositoryModule,
    private val serviceModule: ServiceModule,
    private val applicationContext: Context
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when(modelClass) {
            SplashScreenViewModel::class.java -> {
                return SplashScreenViewModel(useCaseModule.librariesUseCase(
                    repositoryModule.getLibrariesRepository(serviceModule.getServiceImpl(applicationContext)))) as T
            }

            LoginViewModel::class.java -> {
                return LoginViewModel(useCaseModule.checkLoginUseCase(repositoryModule.getLoginRepository(
                    serviceModule.getServiceImpl(applicationContext)
                ))) as T
            }

            RegistrationViewModel::class.java -> {
                return RegistrationViewModel(
                    useCaseModule.registrationUseCase(
                        repositoryModule.getRegistrationRepository(
                            serviceModule.getServiceImpl(applicationContext)
                        )
                    )
                ) as T
            }

            BooksViewModel::class.java -> {
                return BooksViewModel(
                    useCaseModule.bookUseCase(
                        repositoryModule.getBookRepository(
                            serviceModule.getServiceImpl(applicationContext)
                        )
                    )
                ) as T
            }
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}