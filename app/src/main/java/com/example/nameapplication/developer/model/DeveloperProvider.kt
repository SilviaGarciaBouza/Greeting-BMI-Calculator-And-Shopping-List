package com.example.nameapplication.developer.model

class DeveloperProvider {

    companion object {
        fun randomDeveloperModel(): DeveloperModel {
            val numberRandomDeveloper = (0..developerProvider.size - 1).random()
            return developerProvider[numberRandomDeveloper]
        }


        val developerProvider: List<DeveloperModel> = listOf<DeveloperModel>(
            DeveloperModel("Anónimous", "Me encata programar"),
            DeveloperModel("Anónimous", "Programa"),
            DeveloperModel("Anónimous", "Solo programo"),
            DeveloperModel("Anónimous", "Hola"),
            DeveloperModel("Anónimous", "ok")
        )



    }
}