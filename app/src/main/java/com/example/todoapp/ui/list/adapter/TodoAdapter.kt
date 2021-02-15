package com.example.todoapp.ui.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.model.TodoModel
import com.example.todoapp.ui.list.viewholder.TodoHolder
import com.example.todoapp.utils.listener.ClickListener

class TodoAdapter(private val clickListener: ClickListener<TodoModel>) :
    RecyclerView.Adapter<TodoHolder>() {

    private var _list = mutableListOf<TodoModel>()

    fun updateList(list: List<TodoModel>) {
        _list.clear()
        _list.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = _list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder =
        TodoHolder.createHolder(parent)

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        val item = _list[position]
        holder.bind(item, clickListener)
    }


}