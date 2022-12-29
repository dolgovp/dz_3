package com.example.dz_3.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dz_3.data.Event
import com.example.dz_3.data.User

@Database(
    entities = [User::class, Event::class],
    version = 3,
    exportSchema = false
)
abstract class MobileDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun eventDao(): EventDao
}