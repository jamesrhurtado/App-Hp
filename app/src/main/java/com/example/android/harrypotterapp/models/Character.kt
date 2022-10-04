package com.example.android.harrypotterapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
class Character(
    @PrimaryKey
    @SerializedName("character_id")
    var characterId: Int,

    @SerializedName("name")
    var characterName: String,

    @SerializedName("image")
    val characterImg: String,

    @SerializedName("hogwarts_house")
    var hogwartsHouse: String,
)