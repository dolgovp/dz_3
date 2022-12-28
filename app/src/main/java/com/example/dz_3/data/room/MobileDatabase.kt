package com.example.dz_3.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dz_3.data.User

@Database(
    entities = [User::class],
    version = 2,
    exportSchema = false
)
abstract class MobileDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}