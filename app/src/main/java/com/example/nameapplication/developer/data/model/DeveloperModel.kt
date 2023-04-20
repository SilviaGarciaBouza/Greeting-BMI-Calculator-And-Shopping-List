package com.example.nameapplication.developer.data.model

import com.google.gson.annotations.SerializedName

data class DeveloperModel (@SerializedName ("author") val author: String, @SerializedName("quote") val text: String)