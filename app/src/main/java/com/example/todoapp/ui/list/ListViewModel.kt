package com.example.todoapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.dao.TodoDao
import com.example.todoapp.data.mapper.TodoMapper
import com.example.todoapp.model.TodoModel
import kotlinx.coroutines.launch

class ListViewModel(private val todoDao: TodoDao) : ViewModel() {

    private val _todoList = MutableLiveData<List<TodoModel>>()
    val todoList: LiveData<List<TodoModel>>
        get() = _todoList


    fun getTodoList() {
        viewModelScope.launch {
            val list = todoDao.findAll().map {
                TodoMapper.toTodoModel(it)
            }
            _todoList.value = list
        }
    }
}