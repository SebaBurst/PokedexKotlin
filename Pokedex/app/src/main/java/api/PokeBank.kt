package api

import data.Pokemon
import data.PokemonOfficialArtwork
import data.PokemonOther
import data.PokemonSprites
import data.TypeDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeBank {
    private val service : PokeApiCall by lazy{
        val retrofit = Retrofit.Builder()
             .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(PokeApiCall::class.java)
    }

    suspend fun getAllPokemonSpecies(): List<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>()
        var offset = 0 // Inicializar el offset en 0
        val limit = 100 // Establecer un límite de resultados por página

        while (true) {
            val pokemonResponse = service.getAllPokemon(offset, limit)
            val allPokemonUrls = pokemonResponse.results.map { it.url }

            val pokemonDeferred = allPokemonUrls.map { url ->
                CoroutineScope(Dispatchers.IO).async {
                    val pokemonDetails = service.getPokemonInfo(url)
                    val artworkUrl = pokemonDetails.sprites?.other?.officialArtwork?.front_default ?: ""
                    val pokemonName = pokemonDetails.name
                    val pokemonid = pokemonDetails.id


                    val sprites = PokemonSprites(PokemonOther(PokemonOfficialArtwork(artworkUrl)))
                    val pokemon = Pokemon(pokemonid,pokemonName, sprites, pokemonDetails.types)
                    println("Nombre: $pokemonName")

                    pokemonList.add(pokemon)
                }
            }

            val result = pokemonDeferred.awaitAll()
            if (result.isEmpty()) break //

            offset += limit
        }

        return pokemonList
    }}