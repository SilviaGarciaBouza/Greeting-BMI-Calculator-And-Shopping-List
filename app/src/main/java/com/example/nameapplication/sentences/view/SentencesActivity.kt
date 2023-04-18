package com.example.nameapplication.sentences.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.nameapplication.R
import com.example.nameapplication.databinding.ActivitySentencesBinding
import com.example.nameapplication.sentences.viewmodel.SentencesViewModel

class SentencesActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySentencesBinding

    private val sentencesViewModel: SentencesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySentencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //cuando hay cambios pasa esto
        sentencesViewModel.sentencesModel.observe(this, Observer {
            binding.tvSentenceSentences.text= it.sentenceText
            binding.tvAuthorSentences.text = it.sentenceAuthor
        })
        binding.clSentences.setOnClickListener { sentencesViewModel.randomSentence() }
    }
}