package com.example.nameapplication.sentences.model

class SentencesProvider {
    companion object {
        fun randomSentence(): SentencesModel {
            val randomnumber:Int = (1..8).random()
            return sentencesList[randomnumber]
        }
            val sentencesList: List<SentencesModel> = listOf<SentencesModel>(
                SentencesModel("Sonríe y sé feliz", "Anónimo"),
                SentencesModel("Ningún problema debe hacerte sufrir", "Timón y Pumba"),
                SentencesModel("Simplicidad es la máxima sofisticación", "Leonardo Da Vinci"),
                SentencesModel("Entre las dificultades se esconde la oprtunidad", "Einstein"),
                SentencesModel("Trae tu propio sol", "Anónimo"),
                SentencesModel("Haz que cada día sea tu obra maestra", "John Wooden"),
                SentencesModel("Sin lluvia no hay flores", "Anónimo"),
                SentencesModel("Eres lo más, tía", "Anónimo")
            )
        }
    }
