package com.example.todoapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TodoModel(
    val title: String,
    val description: String,
    val createdDate: String,
    val status: TodoState
) : Parcelable