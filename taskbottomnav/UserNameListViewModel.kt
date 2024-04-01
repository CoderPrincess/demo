package com.example.taskbottomnav

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.Flow

class UserNameListViewModel(userRepository: UserRepository, application: Application) : AndroidViewModel(application) {

    val userList: Flow<List<UserDataClass>> = userRepository.getAllUsers()

}

// Flow - A synchronous data stream that sequentially emits value (sending piece of data through stream or channel)
// and completes normally with or with an exception.