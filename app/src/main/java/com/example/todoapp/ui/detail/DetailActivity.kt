package com.example.todoapp.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.R
import com.example.todoapp.ui.create.CreateActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object {
        fun open(context: Context){
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)

        }
    }
}