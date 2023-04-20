package com.example.nameapplication.developer.domain

import com.example.nameapplication.developer.data.DeveloperRepository
import com.example.nameapplication.developer.data.model.DeveloperModel
import com.example.nameapplication.developer.data.model.DeveloperProvider

class GetRandomDeveloperUseCase {
    operator fun invoke(): DeveloperModel?{
        val developers: List<DeveloperModel> = DeveloperProvider.developers
        if(!developers.isNullOrEmpty()){
            val randomNumber:Int = (0..developers.size-1).random()
            return developers[randomNumber]
        }else return null
    }
}