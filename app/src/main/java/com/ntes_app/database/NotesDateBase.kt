package com.ntes_app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ntes_app.database.note.NotesDao
import com.ntes_app.database.user.UserDao
import com.ntes_app.model.entity.NotesEntity
import com.ntes_app.model.entity.UserEntity

@Database(entities = [NotesEntity::class, UserEntity::class], version = 1)
abstract class NotesDateBase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    abstract fun getUserDao(): UserDao

}