package com.example.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoapp.data.converters.TodoStateConverter
import com.example.todoapp.data.dao.TodoDao
import com.example.todoapp.data.entity.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
@TypeConverters(TodoStateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

}
