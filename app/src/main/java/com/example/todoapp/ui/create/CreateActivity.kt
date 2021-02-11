package com.example.todoapp.ui.create

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity
import com.example.todoapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        val saveButton = findViewById<Button>(R.id.saveButton)
        saveButton.setOnClickListener{createTask()}
    }



    companion object {
        fun open(context: Context){
            val intent = Intent(context, CreateActivity::class.java)
            context.startActivity(intent)

        }
    }

    fun createTask(){
        val titleEditText = findViewById<EditText>(R.id.editTextNoteTitle)
        val descrpEditText = findViewById<EditText>(R.id.editTextNoteDescrp)
        val TaskTitle = titleEditText.text
        val TaskDescrp = descrpEditText.text
        //Tamamlanacak
    }


}