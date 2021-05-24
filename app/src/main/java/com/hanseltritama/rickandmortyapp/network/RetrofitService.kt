package com.hanseltritama.rickandmortyapp.network

import com.hanseltritama.rickandmortyapp.data.CharacterResult
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("character/2")
    suspend fun getAllCharacters() : CharacterResult
}