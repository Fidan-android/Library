package com.example.library.data.service.api

class ApiHelper(private val retrofitService: RetrofitService) {
    suspend fun getBooks() = retrofitService.getBooks()
}