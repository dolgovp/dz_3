package com.example.dz_3

import android.content.Context
import androidx.room.Room
import com.example.dz_3.data.repository.EventRepository
import com.example.dz_3.data.repository.UserRepository
import com.example.dz_3.data.room.MobileDatabase

object Graph {
    lateinit var database: MobileDatabase
        private set

    val userRepository by lazy {
        UserRepository(
            userDao = database.userDao()
        )
    }
    val eventRepository by lazy {
        EventRepository(
            eventDao = database.eventDao()
        )
    }
    fun provide(context: Context){
        database = Room.databaseBuilder(context, MobileDatabase::class.java, "data.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}