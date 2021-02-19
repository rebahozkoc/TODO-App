package com.example.todoapp.utils.converters

import com.example.todoapp.model.TodoState

fun fromStringToTodoState(value: String): TodoState {
    return when (value) {
        "TO-DO" -> TodoState.Todo
        "In Process"-> TodoState.InProcess
        "Finished" -> TodoState.Finished
        "Failed" -> TodoState.Failed
        "Waiting" -> TodoState.Waiting
        else -> throw IllegalArgumentException("$value not found in TodoState")
    }
}