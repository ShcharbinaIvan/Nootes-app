package com.ntes_app.repositories

import com.ntes_app.database.note.AppNotesDataBase
import com.ntes_app.model.Note
import com.ntes_app.model.entity.NotesEntity

class NoteRepository {
    suspend fun getAllNotes(): ArrayList<Note> {
        return (AppNotesDataBase.notesDao?.getAllNotes()?.map {
            Note(
                it.name,
                it.date,
                it.message
            )
        } as ArrayList<Note>) ?: arrayListOf()
    }

    suspend fun addNote(note: Note) {
        AppNotesDataBase.notesDao?.addNotes(
            NotesEntity(
                0,
                note.name,
                note.date,
                note.message
            )
        )
    }

    fun deleteNote(note: Note) = AppNotesDataBase.listNotes.remove(note)

}