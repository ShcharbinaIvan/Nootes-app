package com.ntes_app.database.note

import android.content.Context
import androidx.room.Room
import com.ntes_app.database.note.mobile.NotesDao
import com.ntes_app.database.note.mobile.NotesDateBase
import com.ntes_app.model.Note

object AppNotesDataBase {

    var notesDao: NotesDao? = null
    private var notesAppDataBase: NotesDateBase? = null
    val listNotes = arrayListOf<Note>()

    fun initDataBase(context: Context) {
        notesAppDataBase = Room.databaseBuilder(context, NotesDateBase::class.java, "notes-data-base").build()
        notesDao = notesAppDataBase?.getNotesDao()
    }
}