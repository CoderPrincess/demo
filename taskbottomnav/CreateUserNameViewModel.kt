package com.example.taskbottomnav

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CreateUserNameViewModel (
    private val userRepository: UserRepository,
    application: Application
):AndroidViewModel(application) {

    fun saveUser(userName: String, password:String){
        viewModelScope.launch {
            val user = UserDataClass(userName, password)
            if (isUserExists(user)) {
                Toast.makeText(getApplication(), "Username and password already exist", Toast.LENGTH_SHORT).show()
            } else {
                userRepository.insertUser(user)
                Toast.makeText(getApplication(), "Username and password saved successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun isUserExists(userDataClass: UserDataClass): Boolean {
        return userRepository.isUserExists((userDataClass.userName))
    }
}
// Application context is often used for various purposes such as accessing resources, accessing system services, and managing the application lifecycle.
// used to display Toast messages.
// AndroidViewModel is used to create a ViewModel that is lifecycle-aware and retains its state during configuration changes, making it suitable for holding and managing data related to the Android application.