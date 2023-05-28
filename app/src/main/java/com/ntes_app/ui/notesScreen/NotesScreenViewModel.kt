package com.ntes_app.ui.notesScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ntes_app.ui.model.Note
import com.ntes_app.ui.repositories.NoteRepository

class NotesScreenViewModel : ViewModel() {
    val notesList = MutableLiveData<ArrayList<Note>>()
    private val noteRepository = NoteRepository()
    fun getAllNotes() {
        notesList.value = noteRepository.getAllNotes()
    }
}