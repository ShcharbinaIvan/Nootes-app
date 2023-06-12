package com.ntes_app.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(

    @ColumnInfo("userFirstName")
    val userFirstName: String,
    @ColumnInfo("userLastName")
    val userLastName: String,
    @PrimaryKey
    @ColumnInfo("userEmail")
    val userEmail: String,
    @ColumnInfo("userPassword")
    val userPassword: String
)
