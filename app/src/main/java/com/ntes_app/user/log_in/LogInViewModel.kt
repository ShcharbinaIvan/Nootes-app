package com.ntes_app.user.log_in

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val emailUser = MutableLiveData<String>()
    val passwordUser = MutableLiveData<String>()

    fun getUserEmail(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            emailUser.postValue(userRepository.getUser(email)?.userEmail)
            passwordUser.postValue(userRepository.getUser(email)?.userPassword)
        }
    }

//    fun checkUserPassword(password: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            passwordUser.postValue(userRepository.getUser(password)?.userPassword)
//        }
//    }

    fun checkUserEmail(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(email)

        }

    }
}