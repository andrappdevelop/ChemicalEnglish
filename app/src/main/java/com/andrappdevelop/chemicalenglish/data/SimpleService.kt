package com.andrappdevelop.chemicalenglish.data

import com.andrappdevelop.chemicalenglish.domain.SimpleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleService {

    @GET("{fullUrl}")
    suspend fun fetch(@Path(value = "fullUrl", encoded = true) url: String): List<SimpleResponse>
}