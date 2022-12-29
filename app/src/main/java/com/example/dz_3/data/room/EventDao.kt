package com.example.dz_3.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dz_3.data.Event
import com.example.dz_3.data.User
import kotlinx.coroutines.flow.Flow

@Dao
abstract class EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: Event): Long

    @Query(value = "SELECT * FROM events WHERE user_name = :user_name")
    abstract fun getEventsByUserName(user_name: String): Flow<List<Event>>

    @Query(value = "SELECT * FROM events WHERE id = :id")
    abstract suspend fun getEventById(id: Long): Event
}