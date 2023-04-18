package com.example.nameapplication.sentences.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.nameapplication.sentences.model.SentencesModel
import com.example.nameapplication.sentences.model.SentencesProvider

class SentencesViewModel: ViewModel() {

    val sentencesModel = MutableLiveData<SentencesModel>()
    fun randomSentence(){
        val currentSentence:SentencesModel = SentencesProvider.randomSentence()
        sentencesModel.postValue(currentSentence)
    }



}