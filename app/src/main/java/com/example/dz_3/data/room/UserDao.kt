package com.example.dz_3.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dz_3.data.User

@Dao
abstract class UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: User): Long

    @Query(value = "SELECT * FROM users WHERE name = :name")
    abstract suspend fun getUserByName(name: String): User?
}