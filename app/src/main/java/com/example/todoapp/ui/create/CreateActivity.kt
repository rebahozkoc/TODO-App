package com.example.todoapp.ui.create

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todoapp.R
import java.text.SimpleDateFormat
import java.util.Date

class CreateActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        val createDate = findViewById<TextView>(R.id.taskDate)
        createDate.text = "Task created at: " + SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())
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