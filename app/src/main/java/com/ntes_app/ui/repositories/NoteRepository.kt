package com.ntes_app.ui.repositories

import com.ntes_app.ui.database.NoteDataBase
import com.ntes_app.ui.model.Note

class NoteRepository {
    fun getAllNotes() = NoteDataBase.listNotes
    fun getNoteByName(name: String) {
        NoteDataBase.listNotes.find {
            it.name == name
        }
    }

    fun addNote(note: Note) = NoteDataBase.listNotes.add(note)
    fun deleteNote(note: Note) = NoteDataBase.listNotes.remove(note)

}