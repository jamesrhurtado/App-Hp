package com.example.android.harrypotterapp.controller.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.harrypotterapp.R
import com.example.android.harrypotterapp.adapter.SavedCharacterAdapter
import com.example.android.harrypotterapp.database.CharacterDB
import com.example.android.harrypotterapp.models.Character
import kotlinx.android.synthetic.main.fragment_characters.view.*
import kotlinx.android.synthetic.main.fragment_favourites.view.*

class FavouritesFragment: Fragment() {
    var characters: List<Character> =ArrayList()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_favourites,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        characters = CharacterDB.getInstance(view.context).getCharacterDao().getAllCharacters()
        recyclerView = view.rvFavourites
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SavedCharacterAdapter(characters, view.context)
    }
}