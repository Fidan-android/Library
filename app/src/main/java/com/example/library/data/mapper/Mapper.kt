package com.example.library.data.mapper

interface Mapper<Input, Output> {

    fun mapToEntity(data: Input): Output

    fun mapToModel(data: Output): Input
}