package com.example.nameapplication.developer.data.network

import com.example.nameapplication.developer.DeveloperApiClient
import com.example.nameapplication.developer.core.RetrofitHelper
import com.example.nameapplication.developer.data.model.DeveloperModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DeveloperApiService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getDeveloperModel(): List<DeveloperModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<DeveloperModel>> = retrofit.create(DeveloperApiClient::class.java).getAllDeveloperModels()
            response.body() ?: emptyList()
        }
    }
}