package com.example.todoapp.model

data class TodoModel(val title: String,
                     val description: String,
                     val createdDate: String,
                     val status: TodoState)

enum class TodoState(val value:Int) {
    Finished(0),
    InProcess(1),
    Todo(2),
    Failed(3),
    Waiting(4)
}

