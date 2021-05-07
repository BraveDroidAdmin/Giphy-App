package com.bravedroid.giphy.infrastructure.network.services

import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import retrofit2.http.GET

interface GiphyService {
    @GET("random?api_key=aEEX6rcYjx7k5U1jMB0F1LAzZ1pj7p6b")
    suspend fun fetchRandom(): RandomResponse

////    @GET("random?api_key=aEEX6rcYjx7k5U1jMB0F1LAzZ1pj7p6b")
//    @GET("search?api_key=aEEX6rcYjx7k5U1jMB0F1LAzZ1pj7p6b&q=dogs&limit=25&offset=0&rating=g&lang=en")
//    suspend fun fetchGifs(): SearchResponse
}

