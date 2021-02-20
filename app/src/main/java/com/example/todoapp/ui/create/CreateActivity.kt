package com.example.todoapp.ui.create

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.App
import com.example.todoapp.databinding.ActivityCreateBinding
import com.example.todoapp.model.TodoModel
import com.example.todoapp.model.TodoState
import com.example.todoapp.utils.converters.fromStringToTodoState
import com.example.todoapp.utils.converters.getCreateDate
import com.example.todoapp.utils.converters.getSimpleDate
import com.example.todoapp.utils.converters.getUpdateDate

class CreateActivity : AppCompatActivity() {


    private lateinit var binding: ActivityCreateBinding

    private lateinit var viewModel: CreateViewModel

    companion object {
        private const val TODO_MODEL = "TODO_MODEL"
        fun open(context: Context, todoModel: TodoModel? = null) {
            val intent = Intent(context, CreateActivity::class.java).apply {
                putExtra(TODO_MODEL, todoModel)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        val todoModel = intent.extras?.getParcelable<TodoModel>(TODO_MODEL)
        binding.taskDate.text = getCreateDate()
        if (todoModel != null) {
            updateUI(todoModel)
        }

        initListeners(todoModel)

    }

    private fun initViewModel() {
        val viewModelFactory = CreateViewModelFactory(App.appDatabase)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CreateViewModel::class.java)
    }

    private fun createTask() {

        val title = binding.editTextNoteTitle.text.toString()
        val description = binding.editTextNoteDescrp.text.toString()

        val todoModel = TodoModel(
            title = title,
            description = description,
            createdDate = getSimpleDate(),
            status = TodoState.Todo
        )

        viewModel.createTodo(todoModel)
    }

    private fun updateUI(todoModel: TodoModel) {
        binding.apply {
            editTextNoteTitle.setText(todoModel.title)
            editTextNoteDescrp.setText(todoModel.description)
            taskDate.text = getUpdateDate(todoModel.createdDate)
            radioInProcess.isEnabled = true
            radioFailed.isEnabled = true
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

    private fun updateTask(todoModel: TodoModel) {
        val newStatus = findViewById<RadioButton>(binding.radioStatus.checkedRadioButtonId)

        val title = binding.editTextNoteTitle.text.toString()
        val description = binding.editTextNoteDescrp.text.toString()

        val updatedTodoModel = TodoModel(
            id = todoModel.id,
            title = title,
            description = description,
            createdDate = todoModel.createdDate,
            status = fromStringToTodoState(newStatus.text.toString()),
        )

        viewModel.updateTodo(updatedTodoModel)
    }

    private fun initListeners(todoModel: TodoModel?) {
        binding.saveButton.setOnClickListener {
            if (todoModel != null)
                updateTask(todoModel)
            else
                createTask()
        }
    }
}
