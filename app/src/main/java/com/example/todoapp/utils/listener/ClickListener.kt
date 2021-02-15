package com.example.todoapp.utils.listener

interface ClickListener<T> {
    fun onClicked(data: T)
}