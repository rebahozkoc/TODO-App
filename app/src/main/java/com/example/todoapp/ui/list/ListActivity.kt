package com.example.todoapp.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.App
import com.example.todoapp.data.DummyData
import com.example.todoapp.databinding.ActivityListBinding
import com.example.todoapp.model.TodoModel
import com.example.todoapp.ui.create.CreateActivity
import com.example.todoapp.ui.create.CreateViewModel
import com.example.todoapp.ui.create.CreateViewModelFactory
import com.example.todoapp.ui.detail.DetailActivity
import com.example.todoapp.ui.list.adapter.TodoAdapter
import com.example.todoapp.utils.listener.ClickListener

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

        initListeners()

        setTodoAdapter()

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

    private fun initViewModel() {
        val viewModelFactory = ListViewModelFactory(App.appDatabase)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
    }

    private fun initListeners() {
        binding.addNoteButton.setOnClickListener { CreateActivity.open(this) }
    }


}
