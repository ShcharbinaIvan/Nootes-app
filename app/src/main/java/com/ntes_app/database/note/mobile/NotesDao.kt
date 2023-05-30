package com.ntes_app.database.note.mobile

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ntes_app.model.entity.NotesEntity

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNotes(note: NotesEntity)

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<NotesEntity>
}