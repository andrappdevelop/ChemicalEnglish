package com.andrappdevelop.chemicalenglish.domain

class InteractorImpl(
    private val repository: Repository
) : MainInteractor {

    override suspend fun word(): List<SimpleResponse> {
        return repository.load()
    }

    override fun checkCorrectWord(answerWord: String, correctWord: String): Boolean {
        return answerWord == correctWord
    }
}