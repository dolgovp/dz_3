package com.example.dz_3.data.repository

import com.example.dz_3.data.Event
import com.example.dz_3.data.User
import com.example.dz_3.data.room.EventDao
import kotlinx.coroutines.flow.Flow

class EventRepository(
    private val eventDao: EventDao
) {
    fun events(user_name: String): Flow<List<Event>> = eventDao.getEventsByUserName(user_name)
    suspend fun addEvent(event: Event): Long{
        return  when (val local = eventDao.getEventById(event.id)){
            null -> eventDao.insert(event)
            else -> local.id
        }
    }
}