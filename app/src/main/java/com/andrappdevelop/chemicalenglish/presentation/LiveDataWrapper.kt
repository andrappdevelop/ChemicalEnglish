package com.andrappdevelop.chemicalenglish.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.andrappdevelop.chemicalenglish.core.SingleLiveEvent

interface LiveDataWrapper {

    interface Save {
        fun save()
    }

    interface Update {
        fun update(value: UiState)
    }

    interface Observe {
        fun liveData(): LiveData<UiState>
    }

    interface Mutable : Save, Observe, Update

    class Base(private val liveData: MutableLiveData<UiState> = SingleLiveEvent()) : Mutable {
        override fun save() {
            TODO("Not yet implemented")
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}