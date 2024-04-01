package com.example.taskbottomnav

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditUserNameViewModel(
    private val userRepository: UserRepository,
    application: Application
) : AndroidViewModel(application) {

    fun updateUser(username: String, newPassword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUserByUsername(username)
            user?.let {
                val updatedUser = it.copy(password = newPassword)
                userRepository.updateUser(updatedUser)
            }
        }
    }
}
// Dispatchers.IO indicates that this coroutine should be executed on a thread reversed for I/O operations.