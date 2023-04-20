package com.example.nameapplication.developer.domain

import com.example.nameapplication.developer.data.DeveloperRepository
import com.example.nameapplication.developer.data.model.DeveloperModel

class GetDevelopersUseCase {
    private val repository = DeveloperRepository()

    suspend operator fun invoke(): List<DeveloperModel>? = repository.getAllDevelopers()
}