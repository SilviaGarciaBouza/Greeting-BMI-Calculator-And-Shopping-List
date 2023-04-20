package com.example.nameapplication.developer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nameapplication.developer.model.DeveloperModel
import com.example.nameapplication.developer.model.DeveloperProvider

class DeveloperViewModel: ViewModel() {
    val developermodel = MutableLiveData<DeveloperModel>()

    fun randomDeveloper(){
        val currentDeveloper: DeveloperModel = DeveloperProvider.randomDeveloperModel()
        developermodel.postValue(currentDeveloper)
    }
}
