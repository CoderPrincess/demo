package com.example.taskbottomnav

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel (private val userRepository: UserRepository,
                      application: Application) : AndroidViewModel(application) {

    private val loginResultMLD = MutableLiveData<Boolean>()

    val loginResult: LiveData<Boolean>
        get() = loginResultMLD

    fun loginUser(userName: String, password: String) {
        viewModelScope.launch {
            val result = userRepository.verifyUser(userName, password)
            loginResultMLD.value = result
        }
    }
}