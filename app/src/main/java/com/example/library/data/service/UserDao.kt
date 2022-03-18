package com.example.library.data.service

import androidx.room.*
import com.example.library.data.model.LibraryEntity
import com.example.library.data.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity WHERE userLogin=:userLogin")
    fun logIn(userLogin: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun sigUp(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)
}