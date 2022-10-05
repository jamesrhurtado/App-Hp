package com.example.android.harrypotterapp.network

import com.example.android.harrypotterapp.models.ApiResponseDetails
import retrofit2.Call
import retrofit2.http.GET
import com.example.android.harrypotterapp.models.Character

interface CharacterService {
    @GET("characters")
    fun getCharacters(): Call<List<Character>>
}