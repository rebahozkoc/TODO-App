package com.example.todoapp.model

data class TodoModel(
    val title: String,
    val description: String,
    val createdDate: String,
    val status: TodoState
)