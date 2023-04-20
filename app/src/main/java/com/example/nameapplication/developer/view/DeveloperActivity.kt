package com.example.nameapplication.developer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivityDeveloperBinding
import com.example.nameapplication.developer.viewmodel.DeveloperViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DeveloperActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    

    val viewModel: DeveloperViewModel by viewModels()
    private lateinit var binding: ActivityDeveloperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeveloperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit= getRetrofit()
        viewModel.developermodel.observe(this, Observer{
            binding.tvTextDeveloper.text = it.text
            binding.tvAuthorDeveloper.text = it.author
        })

        binding.clDeveloper.setOnClickListener { viewModel.randomDeveloper() }

    }

    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/.json/") //la parte común de la URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }


}