package com.ntes_app.repositories

import com.ntes_app.database.note.NotesDao
import com.ntes_app.model.Note
import com.ntes_app.model.entity.NotesEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val notesDao: NotesDao
) {
//    suspend fun getAllNotes(email: String): ArrayList<Note> {
//        return (notesDao.getAllNotes(email).map {
//            Note(
//                it.email,
//                it.name,
//                it.date,
//                it.message
//            )
//        } as ArrayList<Note>)
//    }

    suspend fun addNote(note: Note) {
        notesDao.addNotes(
            NotesEntity(
                0,
                note.email,
                note.name,
                note.date,
                note.message
            )
        )
    }

    suspend fun deleteNote(note: Note) {
        notesDao.deleteNote(
            NotesEntity(
                note.id,
                note.email,
                note.name,
                note.date,
                note.message
            )
        )
    }

    suspend fun getNotesByEmail(email: String): ArrayList<Note> {
        return (notesDao.getNotesByEmail(email).map {
            Note(
                it.id,
                it.email,
                it.name,
                it.date,
                it.message
            )
        } as ArrayList<Note>)
    }

    suspend fun deleteNotesByEmail(notes: ArrayList<Note>) {
        notesDao.deleteNotesByEmail(notes.map {
            NotesEntity(
                it.id,
                it.email,
                it.name,
                it.date,
                it.message
            )
        })
    }

}