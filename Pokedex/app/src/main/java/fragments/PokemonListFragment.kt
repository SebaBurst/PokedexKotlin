package fragments

import adapters.PokemonAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.PokeBank
import com.example.pokedex.R
import data.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.droidsonroids.gif.GifDrawable
import pl.droidsonroids.gif.GifTextView
import java.util.Locale


class PokemonListFragment : Fragment() {
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: PokemonAdapter
    var allPokemon = ArrayList<Pokemon>()
    lateinit var search: SearchView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allPokemon.clear()
        var loadingAnimation: GifTextView = view.findViewById(R.id.loadingPokemon)

        loadingAnimation.visibility = View.VISIBLE

        recyclerview= view.findViewById(R.id.recyclerViewPokemon)
        val layoutManager = GridLayoutManager(activity, 2)
        recyclerview.layoutManager = layoutManager

        adapter = PokemonAdapter(ArrayList()) // Inicializa el adaptador con una lista vacía
        recyclerview.adapter = adapter

        val job = CoroutineScope(Dispatchers.Main).launch {
            allPokemon = PokeBank.getAllPokemonSpecies() as ArrayList<Pokemon>
            allPokemon.sortBy { it.id }

            adapter.updatePokemonList(allPokemon) // Actualiza la lista en el adaptador
            adapter.notifyDataSetChanged()

            adapter.onItemClick= {
                toPokemonEntry(it.name, it.sprites.other.officialArtwork.front_default)
            }
        }
        recyclerview.viewTreeObserver.addOnGlobalLayoutListener {
            // Verificar si el RecyclerView tiene elementos
            if (recyclerview.adapter?.itemCount ?: 0 > 0) {
                loadingAnimation.visibility = View.GONE // Ocultar la imagen de carga
            }
        }
        search = view.findViewById(R.id.poke_search)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText, adapter)
                return true
            }
        })
    }

    private fun toPokemonEntry(name:String, artwork:String){

        var bundle = Bundle()
        bundle.putString("name", name.trim())
        bundle.putString("artwork", artwork.trim())
        makeCurrentFragment(PokedexEntryFragment(), bundle)
    }

    private fun makeCurrentFragment(fragment: PokedexEntryFragment, bundle: Bundle) {
        val activity = requireContext() as AppCompatActivity
        fragment.arguments = bundle
        activity.supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .addToBackStack(null).commit()
    }
    //filter list Method
    private fun filter(text: String, adapter: PokemonAdapter) {
        var filteredlist = ArrayList<Pokemon>()

        for (item in allPokemon) {
            if (item.name.lowercase().contains(text.lowercase(Locale.getDefault()))) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            adapter.filterList(filteredlist)
        } else {

            adapter.filterList(filteredlist)
        }
    }






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

}
