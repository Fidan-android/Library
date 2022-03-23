package com.example.library.data.mapper

import com.example.library.data.model.BookNetwork
import com.example.library.domain.model.Book

class ApiMapper(): Mapper<Book, BookNetwork> {

    override fun mapToEntity(data: Book): BookNetwork {
        return BookNetwork(id = data.id, title = data.title, subtitle = data.subtitle, author = data.author, pages = data.pages, published = data.published, description = data.description)
    }

    override fun mapToModel(data: BookNetwork): Book {
        return Book(id = data.id, title = data.title, subtitle = data.subtitle, author = data.author, pages = data.pages, published = data.published, description = data.description)
    }

}