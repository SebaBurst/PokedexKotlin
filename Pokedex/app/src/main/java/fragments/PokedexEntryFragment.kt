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

    private lateinit var  typeOne: String
    private lateinit var  typeTwo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonArt : ShapeableImageView = view.findViewById(R.id.pokemon_artwork_entry)
        Picasso.get().load(artwork).into(pokemonArt)
        val pokemonName: TextView = view.findViewById(R.id.namePokemonText)
        pokemonName.text= name

        val type1 : ShapeableImageView = view.findViewById(R.id.typeOne)
        val type2 : ShapeableImageView = view.findViewById(R.id.typeTwo)


        if(typeOne == "fairy"){
            Picasso.get().load(R.drawable.fairy).into(type1)
        }
        else if (typeOne=="fire"){
            Picasso.get().load(R.drawable.fire).into(type1)

        }
        else if (typeOne=="steel"){
            Picasso.get().load(R.drawable.steel).into(type1)

        }
        else if (typeOne=="water"){
            Picasso.get().load(R.drawable.water).into(type1)

        }
        else if (typeOne=="ground"){
            Picasso.get().load(R.drawable.ground).into(type1)

        }
        else if (typeOne=="rock"){
            Picasso.get().load(R.drawable.rock).into(type1)

        }
        else if (typeOne=="dark"){
            Picasso.get().load(R.drawable.dark).into(type1)

        }
        else if (typeOne=="grass"){
            Picasso.get().load(R.drawable.grass).into(type1)

        }
        else if (typeOne=="electric"){
            Picasso.get().load(R.drawable.electric).into(type1)

        }else if (typeOne=="poison"){
            Picasso.get().load(R.drawable.poison).into(type1)

        }
        else if (typeOne=="dragon"){
            Picasso.get().load(R.drawable.dragon).into(type1)

        }
        else if (typeOne=="bug"){
            Picasso.get().load(R.drawable.bug).into(type1)

        }else if (typeOne=="ice"){
            Picasso.get().load(R.drawable.ice).into(type1)

        }
        else if (typeOne=="normal"){
            Picasso.get().load(R.drawable.normal).into(type1)

        }
        else if (typeOne=="fighting"){
            Picasso.get().load(R.drawable.fight).into(type1)

        }
        else if (typeOne=="flying"){
            Picasso.get().load(R.drawable.flying).into(type1)

        }
        else if (typeOne=="psychic"){
            Picasso.get().load(R.drawable.psych).into(type1)

        }
        else if (typeOne=="ghost"){
            Picasso.get().load(R.drawable.ghost).into(type1)

        }





        if(typeTwo == "fairy"){
            Picasso.get().load(R.drawable.fairy).into(type2)
        }
        else if (typeTwo=="fire"){
            Picasso.get().load(R.drawable.fire).into(type2)

        }
        else if (typeTwo=="steel"){
            Picasso.get().load(R.drawable.steel).into(type2)

        }
        else if (typeTwo=="water"){
            Picasso.get().load(R.drawable.water).into(type2)

        }
        else if (typeTwo=="ground"){
            Picasso.get().load(R.drawable.ground).into(type2)

        }
        else if (typeTwo=="rock"){
            Picasso.get().load(R.drawable.rock).into(type2)

        }
        else if (typeTwo=="dark"){
            Picasso.get().load(R.drawable.dark).into(type2)

        }
        else if (typeTwo=="grass"){
            Picasso.get().load(R.drawable.grass).into(type2)

        }
        else if (typeTwo=="electric"){
            Picasso.get().load(R.drawable.electric).into(type2)

        }else if (typeTwo=="poison"){
            Picasso.get().load(R.drawable.poison).into(type2)

        }
        else if (typeTwo=="dragon"){
            Picasso.get().load(R.drawable.dragon).into(type2)

        }
        else if (typeTwo=="bug"){
            Picasso.get().load(R.drawable.bug).into(type2)

        }else if (typeTwo=="ice"){
            Picasso.get().load(R.drawable.ice).into(type2)

        }
        else if (typeTwo=="normal"){
            Picasso.get().load(R.drawable.normal).into(type2)

        }
        else if (typeTwo=="fighting"){
            Picasso.get().load(R.drawable.fight).into(type2)

        }
        else if (typeTwo=="flying"){
            Picasso.get().load(R.drawable.flying).into(type2)

        }
        else if (typeTwo=="psychic"){
            Picasso.get().load(R.drawable.psych).into(type2)

        }
        else if (typeTwo=="ghost"){
            Picasso.get().load(R.drawable.ghost).into(type2)

        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            name = it.getString("name").toString()
            artwork = it.getString("artwork").toString()
            typeOne = it.getString("typeOne").toString()
            typeTwo = it.getString("typeTwo").toString()
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex_entry, container, false)
    }

}