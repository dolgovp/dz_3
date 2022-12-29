package com.example.dz_3.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "events",
    indices = [
        Index("name", unique = true)
    ]

)
data class Event(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id") val id: Long=0,
    @ColumnInfo(name="imgSrc") val imgSrc: String? = null,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="user_name") val user_name: String,
    @ColumnInfo(name="city") val city: String,
    @ColumnInfo(name="date") val date: String,
    @ColumnInfo(name="cat") val cat: String,
    @ColumnInfo(name="like") val like: Int,
    @ColumnInfo(name="users_cnt") val users_cnt: Int,
    @ColumnInfo(name="look_cnt") val look_cnt: Int

)
