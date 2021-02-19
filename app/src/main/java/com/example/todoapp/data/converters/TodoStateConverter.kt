package com.example.todoapp.data.converters

import androidx.room.TypeConverter
import com.example.todoapp.model.TodoState

class TodoStateConverter {

    @TypeConverter
    fun fromTodoState(value: TodoState): Int {
        return value.value
    }

    @TypeConverter
    fun toTodoState(value: Int): TodoState {
        return when (value) {
            TodoState.Todo.value -> TodoState.Todo
            TodoState.InProcess.value -> TodoState.InProcess
            TodoState.Finished.value -> TodoState.Finished
            TodoState.Failed.value -> TodoState.Failed
            TodoState.Waiting.value -> TodoState.Waiting
            else -> throw IllegalArgumentException("$value not found in TodoState")
        }
    }


}