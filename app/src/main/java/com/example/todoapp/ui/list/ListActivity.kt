package com.example.todoapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.todoapp.R
import com.example.todoapp.model.TodoModel
import com.example.todoapp.model.TodoState
import com.example.todoapp.ui.create.CreateActivity
import com.example.todoapp.ui.detail.DetailActivity

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val addNoteButton = findViewById<FloatingActionButton>(R.id.addNoteButton)
        addNoteButton.setOnClickListener{CreateActivity.open(this)}

        val clickableText =findViewById<Button>(R.id.taskDetail)
        clickableText.setOnClickListener { DetailActivity.open(this) }
        val adapter = TodoAdapter()
        val todoList = findViewById<RecyclerView>(R.id.todo_list)
        todoList.adapter = adapter
    }
}

class TodoAdapter: RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    var data =  listOf<TodoModel>(TodoModel("Make Assignments", "Description 1", "02/01/2021", TodoState.Waiting),
        TodoModel("Clean the house", "Description 2", "02/06/2021", TodoState.Failed),
        TodoModel("Go Shopping", "Description 3", "04/01/2021", TodoState.InProcess),
        TodoModel("Make Assignments2", "0", "21/01/2021", TodoState.Waiting),
        TodoModel("Clean the house2", "x", "12/01/2021", TodoState.Todo),
        TodoModel("Go Shopping2", "x", "02/02/2021", TodoState.InProcess),
        TodoModel("Make Assignments3", "0", "3", TodoState.Finished),
        TodoModel("Clean the house3", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping3", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments4", "0", "3", TodoState.Failed),
        TodoModel("Clean the house4", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping4", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments5", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house5", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping5", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments6", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house6", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping6", "x", "y", TodoState.Failed),
        TodoModel("Make Assignments7", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house7", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping3", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments4", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house4", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping4", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments2", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house2", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping2", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments3", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house3", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping3", "x", "y", TodoState.InProcess),
        TodoModel("Make Assignments4", "0", "3", TodoState.Waiting),
        TodoModel("Clean the house4", "x", "y", TodoState.Todo),
        TodoModel("Go Shopping4", "x", "y", TodoState.InProcess))
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.taskTitle.text = item.title
        holder.taskDate.text = item.createdDate
        holder.statusImage.setImageResource(when (item.status){
            TodoState.Failed -> R.drawable.ic_status_red
            TodoState.Finished -> R.drawable.ic_status_green
            TodoState.InProcess -> R.drawable.ic_status_blue
            TodoState.Todo -> R.drawable.ic_status_teal
            TodoState.Waiting -> R.drawable.ic_status_yellow
        })

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.list_item_task, parent, false) as View
        return ViewHolder(view)

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val taskTitle = itemView.findViewById<TextView>(R.id.task_title)
        val taskDate = itemView.findViewById<TextView>(R.id.task_date)
        val statusImage = itemView.findViewById<ImageView>(R.id.task_status)
    }


}
