package com.example.library.data.service

import androidx.room.*
import com.example.library.data.model.LibraryEntity

@Dao
interface LibraryDao {
    @Query("SELECT * FROM LibraryEntity")
    fun getLibraries(): List<LibraryEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLibrary(library: LibraryEntity)

    @Update
    suspend fun updateLibrary(library: LibraryEntity)
}