package com.example.todoapp.ui.detail

import TodoModel
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.todoapp.R
import com.example.todoapp.databinding.ActivityCreateBinding
import com.example.todoapp.databinding.ActivityDetailBinding
import com.example.todoapp.model.TodoState
import com.example.todoapp.ui.create.CreateActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    val todoModel = TodoModel(
        "Make Your Assignments",
        "Maths,\nLinear Algebra,\nHistory",
        "11.02.2021",
        TodoState.Waiting
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val todoModel = intent.extras?.getParcelable<TodoModel>(TODO_MODEL)
        if(todoModel != null) {
            updateUI(todoModel)
        }
        binding.updateButton.setOnClickListener { CreateActivity.open(this) }

    }

    companion object {
            private const val TODO_MODEL = "TODO_MODEL"
            fun open(context: Context, todoModel: TodoModel) {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra(TODO_MODEL, todoModel)
                }
                context.startActivity(intent)

            }
        }
    fun updateUI(todoModel: TodoModel) {

        val taskTitleContent = binding.taskTitleContent
        val taskDescrpContent = binding.taskDescrpContent
        val taskDate = binding.taskDate
        val taskStatus = binding.taskStatus

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