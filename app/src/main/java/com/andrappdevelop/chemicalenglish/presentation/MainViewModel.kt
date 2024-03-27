package com.andrappdevelop.chemicalenglish.presentation

import androidx.lifecycle.ViewModel
import com.andrappdevelop.chemicalenglish.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            val result = repository.load()
            val randomIndex = Random.nextInt(result.size)
            val englishWord = result[randomIndex].englishWord
            val russianWord = result[randomIndex].russianWord
            val fakeRussianWordOne = repository.load()[Random.nextInt(result.size)].russianWord
            val fakeRussianWordTwo = repository.load()[Random.nextInt(result.size)].russianWord
            val fakeRussianWordThree = repository.load()[Random.nextInt(result.size)].russianWord
            liveDataWrapper.update(
                UiState.ShowData(
                    englishWord,
                    russianWord,
                    fakeRussianWordOne,
                    fakeRussianWordTwo,
                    fakeRussianWordThree
                )
            )
        }
    }
}