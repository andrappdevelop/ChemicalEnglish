package com.andrappdevelop.chemicalenglish.domain

interface Repository {

    suspend fun load(): List<SimpleResponse>
}