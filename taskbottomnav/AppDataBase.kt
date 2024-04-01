package com.example.taskbottomnav

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserDataClass::class], version = 1)

abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDataAccessObject

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                instance = db
                db

            }
        }
    }
}

//Companion objects are used to define static members in Kotlin.
//@Volatile annotation ensures that writes to this property are immediately visible to other threads.