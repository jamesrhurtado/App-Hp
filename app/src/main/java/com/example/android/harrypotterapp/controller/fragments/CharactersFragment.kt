package com.example.android.harrypotterapp.controller.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.harrypotterapp.R
import com.example.android.harrypotterapp.adapter.CharacterAdapter
import com.example.android.harrypotterapp.models.ApiResponseDetails
import com.example.android.harrypotterapp.models.Character
import com.example.android.harrypotterapp.network.CharacterService
import kotlinx.android.synthetic.main.fragment_favourites.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment: Fragment() {
    var characters: List<Character> =ArrayList()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_characters,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=rvFavourites
        loadCharacters(view.context)
    }

    private fun loadCharacters(context: Context) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fedeperin-harry-potter-api-en.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val characterService: CharacterService = retrofit.create(CharacterService::class.java)
        val request = characterService.getCharacters()
        request.enqueue(object: Callback<ApiResponseDetails>{
            override fun onFailure(call: Call<ApiResponseDetails>, t: Throwable) {
                Log.d("Activity Fail", "Error: $t")
            }

            override fun onResponse(
                call: Call<ApiResponseDetails>,
                response: Response<ApiResponseDetails>
            ) {
                if(response.isSuccessful){
                    val characters: List<Character> = response.body()!!.characters?:ArrayList()
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = CharacterAdapter(characters, context)
                }else {
                    Log.d("Activity Fail", "Error: "+ response.code())
                }
            }
        })
    }
}