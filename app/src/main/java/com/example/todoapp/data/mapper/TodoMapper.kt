package com.example.todoapp.data.mapper

import com.example.todoapp.data.entity.TodoEntity
import com.example.todoapp.model.TodoModel

object TodoMapper {

    fun toTodoEntity(todoModel: TodoModel): TodoEntity {
        return TodoEntity(
            id = todoModel.id,
            title = todoModel.title,
            description = todoModel.description,
            createdDate = todoModel.createdDate,
            status = todoModel.status
        )
    }

    fun toTodoModel(todoEntity: TodoEntity): TodoModel {
        return TodoModel(
            id = todoEntity.id,
            title = todoEntity.title,
            description = todoEntity.description,
            createdDate = todoEntity.createdDate,
            status = todoEntity.status
        )
    }
}