package com.ntes_app.notesAdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.model.Note
import com.ntes_app.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {
    private val noteRepository = NoteRepository()
    fun addNewNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.addNote(note)
        }
    }
}