package com.example.dz_3.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    indices = [
        Index("name", unique = true)
    ]

)
data class User(
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id") val id: Long=0,
    @ColumnInfo(name="imgSrc") val imgSrc: String? = null,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="city") val city: String,
    @ColumnInfo(name="phone") val phone: String,
    @ColumnInfo(name="email") val email: String,
    @ColumnInfo(name="birthday") val birthday: String,
    @ColumnInfo(name="male") val male: String,
    @ColumnInfo(name="telegram") val telegram: String,
    @ColumnInfo(name="vk") val vk: String,
)

