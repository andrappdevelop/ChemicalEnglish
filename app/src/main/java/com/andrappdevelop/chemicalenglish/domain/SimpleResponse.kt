package com.andrappdevelop.chemicalenglish.domain

import com.google.gson.annotations.SerializedName

data class SimpleResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("eng")
    val englishWord: String,
    @SerializedName("ru")
    val russianWord: String
)