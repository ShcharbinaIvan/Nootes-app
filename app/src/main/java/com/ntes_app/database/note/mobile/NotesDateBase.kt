package com.ntes_app.database.note.mobile

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ntes_app.database.note.mobile.NotesDao
import com.ntes_app.model.entity.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesDateBase : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao
}