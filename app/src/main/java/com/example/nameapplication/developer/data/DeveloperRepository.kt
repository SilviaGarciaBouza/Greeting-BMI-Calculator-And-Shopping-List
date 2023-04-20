package com.example.nameapplication.developer.data

import com.example.nameapplication.developer.data.model.DeveloperModel
import com.example.nameapplication.developer.data.model.DeveloperProvider
import com.example.nameapplication.developer.data.network.DeveloperApiService

class DeveloperRepository {
    private val api = DeveloperApiService()

    suspend fun getAllDevelopers(): List<DeveloperModel> {
        val response: List<DeveloperModel> = api.getDeveloperModel()
        DeveloperProvider.developers = response
        return response
    }
}