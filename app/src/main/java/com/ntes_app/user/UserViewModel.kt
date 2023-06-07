package com.ntes_app.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.model.User
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    var index: Int? = null

    private val userRepository = UserRepository()

    val usersList = MutableLiveData<ArrayList<User>>()
    fun addNewUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }
    }

    fun getAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            usersList.postValue(userRepository.getAllUsers())
        }
    }

}