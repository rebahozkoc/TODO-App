package com.example.todoapp.ui.list.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ListItemTaskBinding
import com.example.todoapp.model.TodoModel
import com.example.todoapp.model.getDrawable
import com.example.todoapp.utils.listener.ClickListener

class TodoHolder(private val binding: ListItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun createHolder(parent: ViewGroup): TodoHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ListItemTaskBinding.inflate(inflater, parent, false)
            return TodoHolder(binding)
        }
    }

    fun bind(todoModel: TodoModel, clickListener: ClickListener<TodoModel>) {
        binding.taskTitle.text = todoModel.title
        binding.taskDate.text = todoModel.createdDate
        binding.taskStatus.setImageResource(
            todoModel.status.getDrawable()
        )

        binding.listCard.setOnClickListener {
            clickListener.onClicked(todoModel)
        }
    }
}