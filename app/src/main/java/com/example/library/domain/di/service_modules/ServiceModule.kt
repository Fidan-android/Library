package com.example.library.domain.di.service_modules

import android.content.Context
import com.example.library.data.service.AppDatabase
import com.example.library.data.service.DbServiceImpl

class ServiceModule() {

    fun getServiceImpl(applicationContext: Context): DbServiceImpl = DbServiceImpl(applicationContext)

    companion object {
        fun getAppDatabase(applicationContext: Context): AppDatabase = AppDatabase.getAppDataBase(applicationContext)!!
    }
}