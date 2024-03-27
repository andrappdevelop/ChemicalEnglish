package com.andrappdevelop.chemicalenglish.presentation

import androidx.lifecycle.ViewModel
import com.andrappdevelop.chemicalenglish.domain.MainInteractor
import com.andrappdevelop.chemicalenglish.domain.SimpleResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val interactor: MainInteractor
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var result: List<SimpleResponse>
    private lateinit var questionWord: SimpleResponse
    private lateinit var answerWordOne: SimpleResponse
    private lateinit var answerWordTwo: SimpleResponse
    private lateinit var answerWordThree: SimpleResponse

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            result = interactor.word()
            val index = result.indices.shuffled()
            questionWord = result[index[0]]
            answerWordOne = result[index[1]]
            answerWordTwo = result[index[2]]
            answerWordThree = result[index[3]]
            liveDataWrapper.update(
                UiState.ShowData(
                    questionWord, answerWordOne, answerWordTwo, answerWordThree
                )
            )
        }
    }

    fun checkAnswer(answer: String): Boolean {
        return interactor.checkCorrectWord(answer, questionWord.russianWord)
    }
}