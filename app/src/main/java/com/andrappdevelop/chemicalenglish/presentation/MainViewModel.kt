package com.andrappdevelop.chemicalenglish.presentation

import android.graphics.Color
import android.view.View
import androidx.lifecycle.ViewModel
import com.andrappdevelop.chemicalenglish.domain.MainInteractor
import com.andrappdevelop.chemicalenglish.domain.SimpleResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.properties.Delegates
import kotlin.random.Random

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val interactor: MainInteractor
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var result: List<SimpleResponse>
    private var randomIndex by Delegates.notNull<Int>()
    private lateinit var questionWord: SimpleResponse
    private lateinit var answerWordOne: SimpleResponse
    private lateinit var answerWordTwo: SimpleResponse
    private lateinit var answerWordThree: SimpleResponse

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            result = interactor.word()
            randomIndex = Random.nextInt(result.size)
            questionWord = result[randomIndex]
            answerWordOne = result[Random.nextInt(result.size)]
            answerWordTwo = result[Random.nextInt(result.size)]
            answerWordThree = result[Random.nextInt(result.size)]
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

    fun changeColor(view: View) {
        view.setBackgroundColor(Color.GRAY)
    }

    fun setGreenColor(view: View) {
        view.setBackgroundColor(Color.GREEN)
    }
}