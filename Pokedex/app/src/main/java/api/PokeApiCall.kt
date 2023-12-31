package api

import data.Pokedex
import data.Pokemon
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApiCall {

    //Se genera una interface para las consultas a la api.
    @GET("pokemon")
    suspend fun getAllPokemon(@Query("offset") offset: Int, @Query("limit") limit: Int): Pokedex
    @GET
    suspend fun getPokemonInfo(@Url url: String): Pokemon
}