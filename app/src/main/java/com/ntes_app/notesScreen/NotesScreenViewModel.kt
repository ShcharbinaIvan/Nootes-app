package com.ntes_app.notesScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.model.Note
import com.ntes_app.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesScreenViewModel : ViewModel() {
    val notesList = MutableLiveData<ArrayList<Note>>()
    private val noteRepository = NoteRepository()
    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(noteRepository.getAllNotes())
        }
    }
}