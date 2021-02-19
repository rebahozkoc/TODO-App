package com.example.todoapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.data.AppDatabase
import com.example.todoapp.ui.create.CreateViewModel

class ListViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(database.todoDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}