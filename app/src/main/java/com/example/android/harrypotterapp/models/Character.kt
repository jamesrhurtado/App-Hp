package com.example.android.harrypotterapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
class Character(
    @PrimaryKey
    @SerializedName("character_id")
    var characterId: Int,

    @SerializedName("character_name")
    var characterName: String,

    @SerializedName("character_img")
    val characterImg: String,

    @SerializedName("hogwarts_house")
    var hogwartsHouse: String,
)