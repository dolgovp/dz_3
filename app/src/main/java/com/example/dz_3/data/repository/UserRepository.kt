package com.example.dz_3.data.repository

import com.example.dz_3.data.User
import com.example.dz_3.data.room.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun user(name: String): User? = userDao.getUserByName(name)
    suspend fun addUser(user: User): Long{
        return  when (val local = userDao.getUserByName(user.name)){
            null -> userDao.insert(user)
            else -> local.id
        }
    }
}