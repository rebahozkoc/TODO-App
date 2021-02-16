package com.example.todoapp.data

import TodoModel
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDatabaseDao {
    @Insert
    fun insert(task: TodoModel)
    @Update
    fun update(task: TodoModel)
    @Query("SELECT * from task_data_table WHERE id = :key")
    fun get(key: Long): TodoModel?
    @Query("SELECT * FROM task_data_table ORDER BY id DESC")
    fun getAllTasks(): List<TodoModel>
}
