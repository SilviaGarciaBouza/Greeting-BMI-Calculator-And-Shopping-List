package com.example.nameapplication.developer.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivityDeveloperBinding
import com.example.nameapplication.developer.ui.viewmodel.DeveloperViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DeveloperActivity : AppCompatActivity() {

    val viewModel: DeveloperViewModel by viewModels()
    private lateinit var binding: ActivityDeveloperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeveloperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.onCreate()
        viewModel.developermodel.observe(this, Observer{
            binding.tvTextDeveloper.text = it.text
            binding.tvAuthorDeveloper.text = it.author
        })
       /*todo viewModel.developermodel.observe(this, Observer {
            binding.pbDeveloper.isVisible= it
        })*/

        binding.clDeveloper.setOnClickListener { viewModel.randomDeveloper() }

    }

}