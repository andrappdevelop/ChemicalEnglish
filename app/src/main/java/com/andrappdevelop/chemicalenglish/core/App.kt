package com.andrappdevelop.chemicalenglish.core

import android.app.Application
import com.andrappdevelop.chemicalenglish.data.RepositoryImpl
import com.andrappdevelop.chemicalenglish.data.SimpleService
import com.andrappdevelop.chemicalenglish.presentation.LiveDataWrapper
import com.andrappdevelop.chemicalenglish.presentation.MainViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var viewModel: MainViewModel

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: SimpleService = retrofit.create(SimpleService::class.java)

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapper.Base(), RepositoryImpl(service, BASE_URL))
    }

    companion object {
        private const val BASE_URL =
            "https://raw.githubusercontent.com/andrappdevelop/ChemicalEnglish/master/app/words.json"
    }
}