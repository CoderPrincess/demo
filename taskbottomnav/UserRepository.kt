package com.example.taskbottomnav

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDataAccessObject) {

    suspend fun insertUser(user: UserDataClass){
        userDao.insertUser(user)
    }

    fun getAllUsers(): Flow<List<UserDataClass>> {
        return userDao.getAllUsers()
    }

    suspend fun verifyUser(userName: String, password: String): Boolean {
        val user = userDao.getUserByUsername(userName)
        return user?.password == password
    }

    suspend fun isUserExists(username: String): Boolean {
        return userDao.getUserByUsername(username) != null
    }

    suspend fun updateUser(user: UserDataClass) {
        userDao.updateUser(user)
    }

    suspend fun getUserByUsername(username: String): UserDataClass? {
        return userDao.getUserByUsername(username)
    }

}

// StateFlow - used to represent a value with a distinct state that can change over time.
// It provides a simple and efficient way to manage and observe state changes in applications.

// Observable - provide a way in which data bound UI can be notified of changes