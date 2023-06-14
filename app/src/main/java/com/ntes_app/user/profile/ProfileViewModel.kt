package com.ntes_app.user.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.repositories.NoteRepository
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val noteRepository: NoteRepository,
    private val sharedPreferenceRepository: SharedPreferenceRepository
) : ViewModel() {

    var userName = MutableLiveData<String>()
    var notesQuantity = MutableLiveData<String>()

    fun deleteUser() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteNotes()
            val user = sharedPreferenceRepository.getCurrentUserEmail()?.let { userRepository.getUser(it) }
            user?.let { userRepository.deleteUser(it) }
        }
    }

    fun getUserName() {
        viewModelScope.launch(Dispatchers.IO) {
            userName.postValue(
                sharedPreferenceRepository.getCurrentUserEmail()?.let {
                    userRepository.getUser(it)!!.userFirstName
                }
                        + " " + sharedPreferenceRepository.getCurrentUserEmail()?.let {
                    userRepository.getUser(
                        it
                    )!!.userLastName
                }
            )
        }
    }

    fun deleteNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            sharedPreferenceRepository.getCurrentUserEmail()?.let {
                noteRepository.getNotesByEmail(
                    it
                )
            }?.let {
                noteRepository.deleteNotesByEmail(
                    it
                )
            }
        }
    }

    fun getAllNotesQuantity() {
        viewModelScope.launch(Dispatchers.IO) {
            notesQuantity.postValue(
                sharedPreferenceRepository.getCurrentUserEmail()?.let {
                    noteRepository.getNotesByEmail(
                        it
                    ).size
                }.toString() + " notes"
            )
        }
    }
}