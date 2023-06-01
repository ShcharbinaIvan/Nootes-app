package com.ntes_app.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("date")
    val date: Long,
    @ColumnInfo("message")
    val message: String
)