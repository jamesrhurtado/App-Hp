package com.example.android.harrypotterapp.database

import androidx.room.*
import com.example.android.harrypotterapp.models.Character

@Dao
interface CharacterDao {
    @Insert
    fun insertCharacter(vararg character: Character)

    @Query("SELECT * FROM characters ")
    fun getAllCharacters(): List<Character>

    @Delete
    fun deleteCharacters(vararg character: Character)

    @Update
    fun updateCharacters(vararg character: Character)
}