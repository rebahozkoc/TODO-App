package com.example.todoapp.ui.detail

import TodoModel
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityDetailBinding
import com.example.todoapp.model.TodoState
import com.example.todoapp.ui.create.CreateActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var todoModel: TodoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val todoModel = intent.extras?.getParcelable<TodoModel>(TODO_MODEL)
        if(todoModel != null) {
            updateUI(todoModel)
        }
        binding.updateButton.setOnClickListener { CreateActivity.open(this, todoModel) }

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
        binding.taskTitleContent.text = todoModel.title
        binding.taskDescrpContent.text = todoModel.description
        binding.taskDate.text = todoModel.createdDate
        when (todoModel.status) {
            TodoState.Finished -> binding.taskStatus.text = "Finished"
            TodoState.InProcess -> binding.taskStatus.text = "In Process"
            TodoState.Todo -> binding.taskStatus.text = "TO-DO"
            TodoState.Failed -> binding.taskStatus.text = "Failed"
            TodoState.Waiting -> binding.taskStatus.text = "Waiting"
        }
    }
}