package com.example.android.harrypotterapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.harrypotterapp.R
import com.example.android.harrypotterapp.database.CharacterDB
import com.example.android.harrypotterapp.models.Character
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.prototype_saved_character.view.*


class SavedCharacterAdapter(private val characters: List<Character>, private val context: Context):
    RecyclerView.Adapter<SavedCharacterAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.tvName
        val tvHouse = view.tvHouse
        val ivCharacter = view.ivCharacter
        val fabRemove = view.fabRemove
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context)
            .inflate(R.layout.prototype_saved_character, parent, false)
        return SavedCharacterAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character=characters[position]
        holder.tvName.text=character.characterName
        holder.tvHouse.text = character.hogwartsHouse
        val picBuilder = Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(character.characterImg).into(holder.ivCharacter)
        holder.fabRemove.setOnClickListener{
            deleteCharacter(character)
        }

    }

    private fun deleteCharacter(character: Character) {
        CharacterDB.getInstance(this.context).getCharacterDao().deleteCharacter(character)

    }

    override fun getItemCount(): Int {
        return characters.size
    }
}