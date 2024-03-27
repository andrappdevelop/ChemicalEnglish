package com.andrappdevelop.chemicalenglish.domain

interface MainInteractor {

    suspend fun word(): List<SimpleResponse>

    fun checkCorrectWord()
}