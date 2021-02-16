package com.example.todoapp.ui.list

import TodoModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.data.DummyData
import com.example.todoapp.data.TaskDatabase
import com.example.todoapp.databinding.ActivityListBinding
import com.example.todoapp.model.TaskViewModel
import com.example.todoapp.model.TaskViewModelFactory
import com.example.todoapp.ui.create.CreateActivity
import com.example.todoapp.ui.detail.DetailActivity
import com.example.todoapp.ui.list.adapter.TodoAdapter
import com.example.todoapp.utils.listener.ClickListener

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()

        setTodoAdapter()
        val application = requireNotNull(this).application

        val dataSource = TaskDatabase.getInstance(application).taskDatabaseDao
        val viewModelFactory = TaskViewModelFactory(dataSource, application)
        val taskViewModel = ViewModelProvider(this, viewModelFactory).get(TaskViewModel::class.java)
        val list = DummyData.getList()
        (binding.todoList.adapter as? TodoAdapter)?.updateList(list)
    }

    private fun setTodoAdapter() {
        binding.todoList.adapter = TodoAdapter(object : ClickListener<TodoModel> {
            override fun onClicked(data: TodoModel) {
                startActivity(intent)
                DetailActivity.open(this@ListActivity, data)

            }

        })
    }

    private fun initListeners() {
        binding.addNoteButton.setOnClickListener { CreateActivity.open(this) }
    }


}
