package com.example.todoapp

import android.app.Application
import androidx.room.Room
import com.example.todoapp.data.AppDatabase

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initDatabase()

    }

    private fun initDatabase() {
        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "todo_db"
        ).build()
    }

    companion object {
        lateinit var appDatabase: AppDatabase
            private set
    }

}