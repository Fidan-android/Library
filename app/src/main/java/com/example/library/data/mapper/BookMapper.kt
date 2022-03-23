package com.example.library.data.mapper

import com.example.library.data.model.BookEntity
import com.example.library.domain.model.Book

class BookMapper(): Mapper<Book, BookEntity> {

    override fun mapToEntity(data: Book): BookEntity {
        return BookEntity(id = data.id, title = data.title, subtitle = data.subtitle, author = data.author, pages = data.pages, published = data.published, description = data.description)
    }

    override fun mapToModel(data: BookEntity): Book {
        return Book(id = data.id, title = data.title, subtitle = data.subtitle, author = data.author, pages = data.pages, published = data.published, description = data.description)
    }

}