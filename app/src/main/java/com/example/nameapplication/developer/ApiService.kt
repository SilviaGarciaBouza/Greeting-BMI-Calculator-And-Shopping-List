package com.example.nameapplication.developer

import retrofit2.http.GET
import com.google.gson.annotations.SerializedName
import retrofit2.Response


interface ApiService {
    @GET
    fun getDevelopers(): Response<List<DeveloperDataResponse>>
}




data class DeveloperDataResponse (
    @SerializedName("author") val author: String,
    @SerializedName("quote") val textQuote: String
)