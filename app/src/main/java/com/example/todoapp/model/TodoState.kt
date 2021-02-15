package com.example.todoapp.model

import com.example.todoapp.R

enum class TodoState(val value: Int) {
    Finished(0),
    InProcess(1),
    Todo(2),
    Failed(3),
    Waiting(4)
}

fun TodoState.getDrawable(): Int =
    when (this) {
        TodoState.Failed -> R.drawable.ic_status_red
        TodoState.Finished -> R.drawable.ic_status_green
        TodoState.InProcess -> R.drawable.ic_status_blue
        TodoState.Todo -> R.drawable.ic_status_teal
        TodoState.Waiting -> R.drawable.ic_status_yellow
    }