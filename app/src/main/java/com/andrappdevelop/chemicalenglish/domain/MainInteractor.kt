package com.andrappdevelop.chemicalenglish.domain

interface MainInteractor {

    suspend fun word(): List<SimpleResponse>

    fun checkCorrectWord(answerWord: String, correctWord: String): Boolean
}