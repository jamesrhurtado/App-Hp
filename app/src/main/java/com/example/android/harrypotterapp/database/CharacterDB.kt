package com.example.android.harrypotterapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Character::class], version = 1)
abstract class CharacterDB: RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
    companion object {

    }
}