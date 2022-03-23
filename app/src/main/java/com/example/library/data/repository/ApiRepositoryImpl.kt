package com.example.library.data.repository

import com.example.library.data.mapper.ApiMapper
import com.example.library.data.service.api.ApiHelper
import com.example.library.domain.model.Book
import com.example.library.domain.repository.IApiRepository

class ApiRepositoryImpl(
    private val apiHelper: ApiHelper,
    private val apiMapper: ApiMapper
): IApiRepository {

    override suspend fun getBooks(): List<Book> {
        val list = apiHelper.getBooks().map {
            apiMapper.mapToModel(it)
        }
        return list
    }

}