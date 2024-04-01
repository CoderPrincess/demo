package com.example.taskbottomnav

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateUserNameViewModelFactory(
    private val application: Application,
    private val userRepository: UserRepository
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CreateUserNameViewModel::class.java)) {
            return CreateUserNameViewModel(userRepository, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}