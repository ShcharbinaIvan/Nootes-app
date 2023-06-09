package com.ntes_app.database.note

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ntes_app.model.entity.NotesEntity

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNotes(note: NotesEntity)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<NotesEntity>

    @Delete
    suspend fun deleteNote(note: NotesEntity)
}