package com.example.android.harrypotterapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
class Character(
    @PrimaryKey
    @SerializedName("id")
    var characterId: Int,

    @SerializedName("character")
    var characterName: String,

    @SerializedName("image")
    val characterImg: String,

    @SerializedName("hogwartsHouse")
    var hogwartsHouse: String,
)