package com.example.library.data.service.api

import com.example.library.data.model.BookNetwork
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RetrofitService {
    @Headers("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.174 YaBrowser/22.1.6.766 Yowser/2.5 Safari/537.36")
    @GET("api/v1/books/")
    suspend fun getBooks(): List<BookNetwork>
}