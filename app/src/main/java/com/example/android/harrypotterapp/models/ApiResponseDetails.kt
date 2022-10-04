package com.example.android.harrypotterapp.models

import com.google.gson.annotations.SerializedName

class ApiResponseDetails(
    @SerializedName("results")
    var results: Int,

    @SerializedName("characters")
    var characters: List<Character>)