package com.andrappdevelop.chemicalenglish.presentation

import androidx.lifecycle.ViewModel
import com.andrappdevelop.chemicalenglish.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
) : ViewModel() {

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            val randomIndex = (0..1).random()
            val result = repository.load()[randomIndex]
            val englishWord = result.englishWord
            val russianWord = result.russianWord
            liveDataWrapper.update(UiState.ShowData(englishWord, russianWord))
        }
    }
}