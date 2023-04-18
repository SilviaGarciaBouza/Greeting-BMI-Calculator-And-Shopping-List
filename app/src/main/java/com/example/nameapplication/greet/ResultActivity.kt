package com.example.nameapplication.greet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name: String = intent.extras?.getString("Extra_name").orEmpty()
        val result = binding.tvResult
        result.text = "Hola $name"
    }
}