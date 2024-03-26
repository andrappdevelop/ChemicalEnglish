package com.andrappdevelop.chemicalenglish.domain

import com.google.gson.annotations.SerializedName

data class SimpleResponse(
    @SerializedName("text")
    val text: String
)
