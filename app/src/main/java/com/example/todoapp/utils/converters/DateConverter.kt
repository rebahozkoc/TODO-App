package com.example.todoapp.utils.converters

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getCreateDate(): String = "Task created on: " +
        SimpleDateFormat("dd/MM/yyyy").format(Date())

fun getUpdateDate(dateString: String) = "Task created on: $dateString"

@SuppressLint("SimpleDateFormat")
fun getSimpleDate(): String = SimpleDateFormat("dd/MM/yyyy").format(Date())