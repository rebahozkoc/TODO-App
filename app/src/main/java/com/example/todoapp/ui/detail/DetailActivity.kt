package com.example.todoapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.databinding.ActivityDetailBinding
import com.example.todoapp.model.TodoModel
import com.example.todoapp.model.TodoState
import com.example.todoapp.ui.create.CreateActivity
import com.example.todoapp.utils.extensions.toast

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
        val view = binding.root
        //setContentView(R.layout.activity_detail)
        setContentView(view)
        updateUI(todoModel)

        val todoModel = intent.extras?.getParcelable<TodoModel>(TODO_MODEL)
        toast(todoModel?.title)

        //val clickableText =findViewById<Button>(R.id.updateButton)
        val clickableText = binding.updateButton
        clickableText.setOnClickListener { CreateActivity.open(this) }

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

        //val taskTitleContent = findViewById<TextView>(R.id.taskTitleContent)
        //val taskDescrpContent = findViewById<TextView>(R.id.taskDescrpContent)
        //val taskDate = findViewById<TextView>(R.id.taskDate)
        //val taskStatus = findViewById<TextView>(R.id.taskStatus)


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