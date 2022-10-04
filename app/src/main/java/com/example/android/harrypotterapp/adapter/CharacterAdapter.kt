package com.example.android.harrypotterapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.harrypotterapp.R
import kotlinx.android.synthetic.main.prototype_saved_character.view.*

class CharacterAdapter(private val characters: List<Character>, private val context: Context):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.tvName
        val tvHouse = view.tvHouse
        val ivCharacter = view.ivCharacter
        val fabFavourite = view.fabFavourite
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context)
            .inflate(R.layout.prototype_character, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}