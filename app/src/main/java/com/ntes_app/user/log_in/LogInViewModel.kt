package com.ntes_app.user.log_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun getUserEmail(email: String): String {
        var emailUser = ""
        viewModelScope.launch(Dispatchers.IO) {
            emailUser = userRepository.getUser(email).userEmail
        }
        return emailUser
    }
    fun getUserPassword(email: String): String {
        var emailPassword = ""
        viewModelScope.launch(Dispatchers.IO) {
            emailPassword = userRepository.getUser(email).userPassword
        }
        return emailPassword
    }
}