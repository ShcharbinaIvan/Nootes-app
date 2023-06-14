package com.ntes_app.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.model.Note
import com.ntes_app.repositories.NoteRepository
import com.ntes_app.repositories.SharedPreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val sharedPreferenceRepository: SharedPreferenceRepository
) : ViewModel() {

    val notesListByMessage = MutableLiveData<ArrayList<Note>>()
    val notesByMessage = MutableLiveData<ArrayList<String>>()

    fun getNoteByMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            notesListByMessage.postValue(
                sharedPreferenceRepository.getCurrentUserEmail()?.let {
                    noteRepository.getNotesByEmail(
                        it
                    )
                }
            )
        }
    }

}