package com.example.nameapplication.developer.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nameapplication.developer.data.model.DeveloperModel
import com.example.nameapplication.developer.data.model.DeveloperProvider
import com.example.nameapplication.developer.domain.GetDevelopersUseCase
import com.example.nameapplication.developer.domain.GetRandomDeveloperUseCase
import kotlinx.coroutines.launch

class DeveloperViewModel: ViewModel() {
    val developermodel = MutableLiveData<DeveloperModel>()
    val isLoading = MutableLiveData<Boolean>()
    //llamada al caso de uso:
    var getDevelopersuseCase= GetDevelopersUseCase()
    var getRandomDeveloperUseCase= GetRandomDeveloperUseCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<DeveloperModel>? = getDevelopersuseCase()
            //para q empiece con una frase
            if(!result.isNullOrEmpty()){
                developermodel.postValue(result[0])
                isLoading.postValue(false)

            }
        }
    }


    fun randomDeveloper(){
        isLoading.postValue(true)
        val developerSentence: DeveloperModel? = getRandomDeveloperUseCase()
        if(developerSentence!=null){
            developermodel.postValue(developerSentence)
        }
        isLoading.postValue(false)

    }
}
