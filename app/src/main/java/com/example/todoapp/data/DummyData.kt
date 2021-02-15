package com.example.todoapp.data

import TodoModel
import com.example.todoapp.model.TodoState

object DummyData {

    fun getList(): List<TodoModel> = listOf(
        TodoModel("Make Assignments", "Description 1", "02/01/2021", TodoState.Waiting),
        TodoModel("Clean the house", "Description 2", "02/06/2021", TodoState.Failed),
        TodoModel("Go Shopping", "Description 3", "04/01/2021", TodoState.InProcess),
        TodoModel("Make Assignments2", "0", "21/01/2021", TodoState.Waiting),
        TodoModel("Clean the house2", "x", "12/01/2021", TodoState.Todo),
        TodoModel("Go Shopping2", "x", "02/02/2021", TodoState.InProcess),
        TodoModel("Make Assignments3", "0", "02/12/2021", TodoState.Finished),
        TodoModel("Clean the house3", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping3", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments4", "0", "3", TodoState.Failed),
        TodoModel("Clean the house4", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping4", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments5", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house5", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping5", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments6", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house6", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping6", "x", "y", TodoState.Failed),
        TodoModel("Make Assignments7", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house7", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping3", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments4", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house4", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping4", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments2", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house2", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping2", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments3", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house3", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping3", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments4", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house4", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping4", "x", "y", TodoState.InProcess)
    )
}