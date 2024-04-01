package com.example.taskbottomnav

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDataAccessObject {

    @Insert/*(onConflict = OnConflictStrategy.IGNORE)*/
    suspend fun insertUser(userDataClass: UserDataClass)

    @Query("SELECT * FROM user WHERE username = :userName")
    suspend fun getUserByUsername(userName: String): UserDataClass?

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<UserDataClass>>

    @Update
    suspend fun updateUser(user: UserDataClass)

}
// OnConflictStrategy.IGNORE - to keep the existing rows.
// OnConflictStrategy.ABORT - to roll back the transaction on conflict.
// OnConflictStrategy.REPLACE - to replace the existing rows with the new rows.
// OnConflictStrategy.NONE -  It may be useful when there is a need to use ON CONFLICT clause within a trigger.