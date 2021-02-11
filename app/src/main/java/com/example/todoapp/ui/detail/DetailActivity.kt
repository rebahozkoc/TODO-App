package com.example.todoapp.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.todoapp.R
import com.example.todoapp.model.TodoModel
import com.example.todoapp.model.TodoState
import com.example.todoapp.ui.create.CreateActivity

class DetailActivity : AppCompatActivity() {

    val todoModel = TodoModel(
        "Make Your Assignments",
        "Maths,\nLinear Algebra,\nHistory",
        "11.02.2021",
        TodoState.Waiting
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        updateUI(todoModel)

        val clickableText =findViewById<Button>(R.id.updateButton)
        clickableText.setOnClickListener { CreateActivity.open(this) }

    }

    companion object {
        fun open(context: Context) {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)

        }
    }

    fun updateUI(todoModel: TodoModel) {
        val taskTitleContent = findViewById<TextView>(R.id.taskTitleContent)
        val taskDescrpContent = findViewById<TextView>(R.id.taskDescrpContent)
        val taskDate = findViewById<TextView>(R.id.taskDate)
        val taskStatus = findViewById<TextView>(R.id.taskStatus)

        taskTitleContent.text = todoModel.title
        taskDescrpContent.text = todoModel.description
        taskDate.text = todoModel.createdDate
        when (todoModel.status) {
            TodoState.Finished -> taskStatus.text = "Finished"
            TodoState.InProcess -> taskStatus.text = "In Process"
            TodoState.Todo -> taskStatus.text = "TO-DO"
            TodoState.Failed -> taskStatus.text = "Failed"
            TodoState.Waiting -> taskStatus.text = "Waiting"
        }
    }
}