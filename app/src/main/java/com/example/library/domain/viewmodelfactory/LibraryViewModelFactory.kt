package com.example.library.domain.viewmodelfactory

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.library.domain.di.mapper_modules.MapperModule
import com.example.library.domain.di.repository_modules.RepositoryModule
import com.example.library.domain.di.service_modules.ServiceModule
import com.example.library.domain.di.use_case_modules.UseCaseModule
import com.example.library.domain.viewmodel.BooksViewModel
import com.example.library.domain.viewmodel.LoginViewModel
import com.example.library.domain.viewmodel.RegistrationViewModel
import com.example.library.domain.viewmodel.SplashScreenViewModel

@Suppress("UNCHECKED_CAST")
class LibraryViewModelFactory(
    private val useCaseModule: UseCaseModule,
    private val repositoryModule: RepositoryModule,
    private val serviceModule: ServiceModule,
    private val applicationContext: Context
): ViewModelProvider.Factory {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when(modelClass) {
            SplashScreenViewModel::class.java -> {
                return SplashScreenViewModel(useCaseModule.librariesUseCase(applicationContext, repositoryModule.getLibrariesRepository(
                        ServiceModule.getAppDatabase(applicationContext), MapperModule.getLibraryMapper())
                )) as T
            }

            LoginViewModel::class.java -> {
                return LoginViewModel(useCaseModule.loginUseCase(applicationContext, repositoryModule.getLoginRepository(
                    ServiceModule.getAppDatabase(applicationContext), MapperModule.getLoginMapper()
                ))) as T
            }

            RegistrationViewModel::class.java -> {
                return RegistrationViewModel(useCaseModule.registrationUseCase(applicationContext, repositoryModule.getRegistrationRepository(
                    ServiceModule.getAppDatabase(applicationContext), MapperModule.getLoginMapper()
                ))) as T
            }

            BooksViewModel::class.java -> {
                return BooksViewModel(useCaseModule.bookUseCase(applicationContext,
                    repositoryModule.getBookRepository(
                        ServiceModule.getAppDatabase(applicationContext),
                        MapperModule.getBookMapper()),
                    repositoryModule.getApiRepository(
                        ServiceModule.getApiHelper(),
                        MapperModule.getApiMapper()
                    )
                )) as T
            }
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}