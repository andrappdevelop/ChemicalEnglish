package com.andrappdevelop.chemicalenglish.presentation

import androidx.lifecycle.ViewModel
import com.andrappdevelop.chemicalenglish.domain.MainInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val interactor: MainInteractor
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            val result = interactor.word()
            val randomIndex = Random.nextInt(result.size)
            val questionWord = result[randomIndex]
            val answerWordOne = result[Random.nextInt(result.size)]
            val answerWordTwo = result[Random.nextInt(result.size)]
            val answerWordThree = result[Random.nextInt(result.size)]
            liveDataWrapper.update(
                UiState.ShowData(
                    questionWord, answerWordOne, answerWordTwo, answerWordThree
                )
            )
        }
    }

    fun checkAnswer() {
        interactor.checkCorrectWord()
    }
}