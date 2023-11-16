package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pokedex.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import data.PokemonOfficialArtwork


class PokedexEntryFragment : Fragment() {

    private lateinit var  name: String
    private lateinit var  artwork: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonArt : ShapeableImageView = view.findViewById(R.id.pokemon_artwork_entry)
        Picasso.get().load(artwork).into(pokemonArt)
        val pokemonName: TextView = view.findViewById(R.id.namePokemonText)
        pokemonName.text= name




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            name = it.getString("name").toString()
            artwork = it.getString("artwork").toString()
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex_entry, container, false)
    }

}