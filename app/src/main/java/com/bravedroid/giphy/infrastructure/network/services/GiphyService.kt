package com.bravedroid.giphy.infrastructure.network.services

import com.bravedroid.giphy.infrastructure.network.models.random.RandomResponse
import retrofit2.http.GET

interface GiphyService {
    @GET("/random?api_key=aEEX6rcYjx7k5U1jMB0F1LAzZ1pj7p6b")
    suspend fun fetchRandom(): RandomResponse
}
