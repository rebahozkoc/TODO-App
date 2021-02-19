package com.example.todoapp.ui.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.dao.TodoDao
import com.example.todoapp.data.mapper.TodoMapper
import com.example.todoapp.model.TodoModel
import kotlinx.coroutines.launch

class CreateViewModel(private val todoDao: TodoDao) : ViewModel() {


    fun createTodo(todoModel: TodoModel) {
        val todoEntity = TodoMapper.toTodoEntity(todoModel)

        viewModelScope.launch {
            todoDao.insert(todoEntity = todoEntity)
        }
    }

    fun updateTodo(todoModel: TodoModel) {
        val todoEntity = TodoMapper.toTodoEntity(todoModel)

        viewModelScope.launch {
            todoDao.update(todoEntity)
        }
    }
}