package com.example.android.harrypotterapp.controller.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.android.harrypotterapp.R
import com.example.android.harrypotterapp.controller.fragments.CharactersFragment
import com.example.android.harrypotterapp.controller.fragments.FavouritesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.
    OnNavigationItemSelectedListener { item -> navigateTo(item)}

    private fun navigateTo(item: MenuItem): Boolean {
        item.isChecked = true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment, getFragmentFor(item))
            .commit() > 0
    }

    private fun getFragmentFor(item: MenuItem): Fragment {
        return when(item.itemId) {
            R.id.menu_home -> CharactersFragment()
            R.id.menu_favourites -> FavouritesFragment()
            else -> CharactersFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}