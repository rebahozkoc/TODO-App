package com.example.todoapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.data.TaskDatabaseDao

class TaskViewModel(
    val database: TaskDatabaseDao,
    application: Application): AndroidViewModel(application){
}