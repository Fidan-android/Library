package com.example.library

import android.app.Application
import android.content.Context
import android.util.Log
import com.example.library.data.model.LibraryEntity
import com.example.library.data.service.AppDatabase
import kotlinx.coroutines.*

class GlobalApplication: Application() {

    private var appContext: Context? = null
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        GlobalScope.launch(Dispatchers.IO) {
            val appDb: AppDatabase = AppDatabase.getAppDataBase(applicationContext)!!

            if (appDb.libraryDao().getLibraries().isEmpty()) {
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 1", false))
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 2", false))
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 3", false))
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 4", false))
            }
            appDb.libraryDao().getLibraries().map {
                Log.d("DATA", it.name)
            }
        }
    }

    fun getAppContext(): Context? {
        return appContext
    }
}