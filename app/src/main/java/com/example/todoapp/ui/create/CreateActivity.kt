package com.example.todoapp.ui.create

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.todoapp.R

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
    }



    companion object {
        fun open(context: Context){
            val intent = Intent(context, CreateActivity::class.java)
            context.startActivity(intent)

        }
    }

}