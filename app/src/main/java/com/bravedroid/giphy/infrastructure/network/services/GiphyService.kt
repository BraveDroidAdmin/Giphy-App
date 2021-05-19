package com.bravedroid.giphy.infrastructure.network.services

import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import com.bravedroid.giphy.infrastructure.network.models.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyService {
    @GET("random?api_key=5nQ8AxEvNclkNyKHb0EoXIGCL63dGqMI")
    suspend fun fetchRandom(): RandomResponse

    @GET("search?api_key=5nQ8AxEvNclkNyKHb0EoXIGCL63dGqMI")//todo add thes param &limit=25&offset=0&rating=g
    suspend fun fetchGifs(@Query("q") query: String): SearchResponse
}

