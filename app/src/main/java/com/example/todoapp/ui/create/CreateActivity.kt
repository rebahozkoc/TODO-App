package com.example.todoapp.ui.create

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityCreateBinding
import com.example.todoapp.utils.converters.getCreateDate


class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.taskDate.text = getCreateDate()
        binding.saveButton.setOnClickListener{createTask()}
    }


    companion object {
        fun open(context: Context){
            val intent = Intent(context, CreateActivity::class.java)
            context.startActivity(intent)
        }
    }

    fun createTask(){
        val titleEditText = binding.editTextNoteTitle
        val descrpEditText = binding.editTextNoteDescrp
        val TaskTitle = titleEditText.text
        val TaskDescrp = descrpEditText.text
        //Tamamlanacak
    }
}