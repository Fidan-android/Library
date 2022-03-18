package com.example.library.data.mapper

import com.example.library.data.model.LibraryEntity
import com.example.library.domain.model.Library

class LibraryMapper(): Mapper<Library, LibraryEntity> {

    override fun mapToEntity(data: Library): LibraryEntity {
        return LibraryEntity(id = data.id, name = data.name, changed = false)
    }

    override fun mapToModel(data: LibraryEntity): Library {
        return Library(id = data.id, name = data.name)
    }

}