package com.andrappdevelop.chemicalenglish.data

import com.andrappdevelop.chemicalenglish.domain.Repository
import com.andrappdevelop.chemicalenglish.domain.SimpleResponse

class RepositoryImpl(
    private val service: SimpleService,
    private val url: String
) : Repository {
    override suspend fun load(): SimpleResponse {
        return service.fetch(url)
    }
}