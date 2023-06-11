package com.ntes_app.user.sing_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.model.User
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingUpViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sharedPreferenceRepository: SharedPreferenceRepository
) : ViewModel() {

    fun addNewUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }



//    fun getUserEmail(email: String): String {
//        var emailUser: String = ""
//        viewModelScope.launch(Dispatchers.IO) {
//            emailUser = userRepository.getUser(email).userEmail
//        }
//        return emailUser
//    }


}