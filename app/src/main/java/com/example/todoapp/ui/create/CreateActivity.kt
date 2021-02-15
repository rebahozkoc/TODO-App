package com.example.todoapp.ui.create

import TodoModel
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityCreateBinding
import com.example.todoapp.model.TodoState
import com.example.todoapp.ui.detail.DetailActivity
import com.example.todoapp.utils.converters.getCreateDate
import com.example.todoapp.utils.converters.getUpdateDate
import com.example.todoapp.utils.extensions.toast

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding
    private lateinit var todoDATA: TodoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val todoModel = intent.extras?.getParcelable<TodoModel>(TODO_MODEL)
        binding.taskDate.text = getCreateDate()
        if(todoModel != null) {
            updateUI(todoModel)
        }

        initListeners()

    }

    companion object {
            private const val TODO_MODEL = "TODO_MODEL"
            fun open(context: Context, todoModel: TodoModel? = null) {
                val intent = Intent(context, CreateActivity::class.java).apply {
                    putExtra(TODO_MODEL, todoModel)
                }
                context.startActivity(intent)
            }
        }



    fun createTask() {
        val titleEditText = binding.editTextNoteTitle
        val descrpEditText = binding.editTextNoteDescrp
        val TaskTitle = titleEditText.text
        val TaskDescrp = descrpEditText.text
        //Tamamlanacak
    }

    private fun updateUI(todoModel: TodoModel) {
        binding.apply {
            editTextNoteTitle.setText(todoModel.title)
            editTextNoteDescrp.setText(todoModel.description)
            taskDate.text = getUpdateDate(todoModel.createdDate)
            radioInProcess.isEnabled= true
            radioFailed.isEnabled= true
            radioFinished.isEnabled = true
            radioWaiting.isEnabled = true
        }
        when (todoModel.status) {
            TodoState.Finished -> binding.radioFinished.isChecked = true
            TodoState.InProcess -> binding.radioInProcess.isChecked = true
            TodoState.Todo -> binding.radioTodo.isChecked = true
            TodoState.Failed -> binding.radioFailed.isChecked = true
            TodoState.Waiting -> binding.radioWaiting.isChecked = true
        }
    }
    private fun initListeners() {
        binding.saveButton.setOnClickListener { createTask() }
    }
}
