package com.ntes_app.ui.notesAdd

import androidx.lifecycle.ViewModel
import com.ntes_app.ui.model.Note
import com.ntes_app.ui.repositories.NoteRepository

class AddNoteViewModel : ViewModel() {
    private val noteRepository = NoteRepository()
    fun addNewNote(note: Note) {
        noteRepository.addNote(note)
    }
}