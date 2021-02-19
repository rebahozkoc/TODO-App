package com.example.todoapp.data.dao

import androidx.room.*
import com.example.todoapp.data.entity.TodoEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM todos")
    suspend fun findAll(): List<TodoEntity>

    @Insert
    suspend fun insert(todoEntity: TodoEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(todoEntity: TodoEntity)

    @Delete
    suspend fun delete(todoEntity: TodoEntity)
}
