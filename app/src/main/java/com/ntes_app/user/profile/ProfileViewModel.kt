package com.ntes_app.user.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.model.Note
import com.ntes_app.repositories.NoteRepository
import com.ntes_app.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository
) : ViewModel() {

    var notesListEmail = MutableLiveData<ArrayList<Note>>()

    fun deleteUser(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(email)
            userRepository.deleteUser(user)
        }
    }

    fun getUserName(email: String): String {
        var firstName = ""
        var lastName = ""
        viewModelScope.launch(Dispatchers.IO) {
            firstName = userRepository.getUser(email).userFirstName
            lastName = userRepository.getUser(email).userLastName
        }
        return "$firstName $lastName"
    }

    fun getNotesByEmail(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notesListEmail.postValue(noteRepository.getNotesByEmail(email))
        }
    }

    fun deleteNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.deleteNotesByEmail(notesListEmail.value!!)
        }
    }

    fun getAllNotesQuantity(email: String): String {
        var quantity = ""
        viewModelScope.launch(Dispatchers.IO) {
            quantity = noteRepository.getAllNotes(email).size.toString()
        }
        return quantity
    }
}