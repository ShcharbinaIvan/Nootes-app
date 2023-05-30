package com.ntes_app.notesAdd

import androidx.lifecycle.ViewModel
import com.ntes_app.model.Note
import com.ntes_app.repositories.NoteRepository

class AddNoteViewModel : ViewModel() {
    private val noteRepository = NoteRepository()
    suspend fun addNewNote(note: Note) {
        noteRepository.addNote(note)
    }
}