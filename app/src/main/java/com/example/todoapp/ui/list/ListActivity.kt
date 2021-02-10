package com.example.todoapp.ui.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.todoapp.R
import com.example.todoapp.ui.create.CreateActivity

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val addNoteButton = findViewById<FloatingActionButton>(R.id.addNoteButton)
        addNoteButton.setOnClickListener{CreateActivity.open(this)}
    }
}