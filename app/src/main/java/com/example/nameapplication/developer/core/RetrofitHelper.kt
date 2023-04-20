package com.example.nameapplication.developer.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/") //la parte común de la URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}