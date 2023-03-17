package com.example.nameapplication.greet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nameapplication.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name: String = intent.extras?.getString("Extra_name").orEmpty()
        val result = findViewById<TextView>(R.id.tvResult)
        result.text = "Hola $name"
    }
}