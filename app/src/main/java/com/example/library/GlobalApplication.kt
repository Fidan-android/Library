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

        CoroutineScope(Dispatchers.IO).launch {
            val appDb: AppDatabase = AppDatabase.getAppDataBase(applicationContext)!!

            if (appDb.libraryDao().getLibraries().isEmpty()) {
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 1", false))
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 2", false))
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 3", false))
                appDb.libraryDao().addLibrary(LibraryEntity(0, "Библиотека 4", false))
            }
        }
    }

    fun getAppContext(): Context? {
        return appContext
    }
}