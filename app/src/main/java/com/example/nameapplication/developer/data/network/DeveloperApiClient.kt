package com.example.nameapplication.developer

import com.example.nameapplication.developer.data.model.DeveloperModel
import retrofit2.http.GET
import retrofit2.Response


interface DeveloperApiClient {
    @GET("/.json/")
    suspend fun getAllDeveloperModels(): Response<List<DeveloperModel>>
}

