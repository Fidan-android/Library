package com.example.library.domain.di.service_modules

import android.content.Context
import com.example.library.data.service.AppDatabase
import com.example.library.data.service.api.ApiHelper
import com.example.library.data.service.api.RetrofitBuilder

class ServiceModule() {
    companion object {
        fun getAppDatabase(applicationContext: Context): AppDatabase = AppDatabase.getAppDataBase(applicationContext)!!

        fun getApiHelper(): ApiHelper = ApiHelper(RetrofitBuilder.retrofitService)
    }
}