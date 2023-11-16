package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragments.PokeWatchFragment
import fragments.PokemonListFragment


class MainActivity : AppCompatActivity() {

    private val PokedexListFragment = PokemonListFragment()
    private val PokedexWatchFragment = PokeWatchFragment()

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeCurrentFragment(PokedexListFragment)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.pokedex -> makeCurrentFragment(PokedexListFragment)
                R.id.PokeWatch -> makeCurrentFragment(PokedexWatchFragment)

            }
            true
        }
    }

    // Funcion que cambia los fragmentos dentro de la activiada
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}