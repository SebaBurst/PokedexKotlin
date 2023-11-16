package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import data.Pokemon

class PokemonAdapter(private var pokemonList: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.MyViewHolder>() {

    var onItemClick : ((Pokemon) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return MyViewHolder(view)
    }


    fun updatePokemonList(newPokemonList: List<Pokemon>) {
        pokemonList = newPokemonList // Actualiza la lista de Pokémon en el adaptador
        notifyDataSetChanged() // Notifica al RecyclerView sobre el cambio en los datos
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val contexto = holder.itemView.context // Aquí obtienes el contexto desde la vista del ViewHolder
        val currentPokemon = pokemonList[position]
        val artworkUrl = currentPokemon.sprites.other.officialArtwork.front_default

        if (artworkUrl.isNotEmpty()) {
            Picasso.get().load(artworkUrl).into(holder.artworkPokemon)
        } else {
        }

        holder.pokedexNumber.text = currentPokemon.id.toString()
        val miDrawable = ContextCompat.getDrawable(contexto, R.drawable.circle)

        if(currentPokemon.types[0].type.name == "electric"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.electric))
        }
        else if(currentPokemon.types[0].type.name == "normal"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.normal))
        }
        else if(currentPokemon.types[0].type.name == "water"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.water))
        }
        else if(currentPokemon.types[0].type.name == "ice"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.ice))
        }
        else if(currentPokemon.types[0].type.name == "fire"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.fire))
        }
        else if(currentPokemon.types[0].type.name == "grass"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.grass))
        }
        else if(currentPokemon.types[0].type.name == "steel"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.steel))
        }
        else if(currentPokemon.types[0].type.name == "poison"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.poison))
        }
        else if(currentPokemon.types[0].type.name == "fairy"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.fairy))
        }
        else if(currentPokemon.types[0].type.name == "psychic"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.psychic))
        }
        else if(currentPokemon.types[0].type.name == "dragon"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.dragon))
        }
        else if(currentPokemon.types[0].type.name == "bug"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.bug))
        }
        else if(currentPokemon.types[0].type.name == "dark"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.dark))
        }
        else if(currentPokemon.types[0].type.name == "ghost"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.ghost))
        }
        else if(currentPokemon.types[0].type.name == "flying"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.flying))
        }
        else if(currentPokemon.types[0].type.name == "fighting"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.fight))
        }
        else if(currentPokemon.types[0].type.name == "rock"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.rock))
        }
        else if(currentPokemon.types[0].type.name == "ground"){
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.ground))
        }

        else{
            DrawableCompat.setTint(miDrawable!!, ContextCompat.getColor(contexto, R.color.red_circle))

        }

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentPokemon)
        }
        holder.typeBackground.background = miDrawable



    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val artworkPokemon: ShapeableImageView = itemView.findViewById(R.id.pokemon_artwork_list);
        val typeBackground: ImageView = itemView.findViewById(R.id.poke_item_bg)
        val pokedexNumber: TextView = itemView.findViewById(R.id.numberPokedex)


    }

    public fun filterList(pokeListFilter: ArrayList<Pokemon>) {
        pokemonList = pokeListFilter
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}