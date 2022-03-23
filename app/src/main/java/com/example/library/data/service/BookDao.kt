package com.example.library.data.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.library.data.model.BookEntity

@Dao
interface BookDao {
    @Query("SELECT * FROM BookEntity")
    fun getBooks(): List<BookEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertBooks(boos: List<BookEntity>)
}