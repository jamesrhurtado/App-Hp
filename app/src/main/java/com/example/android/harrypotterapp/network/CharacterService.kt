package com.example.android.harrypotterapp.network

import com.example.android.harrypotterapp.models.ApiResponseDetails
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {
    @GET("characters")
    fun getCharacters(): Call<ApiResponseDetails>
}