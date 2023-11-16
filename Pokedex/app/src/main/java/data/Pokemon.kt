package data

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: Int,
    val name:String,
    val sprites: PokemonSprites,
    val types: List<TypeDetail>



)
data class PokemonSprites(
    val other: PokemonOther
)

data class TypeDetail(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)




data class PokemonOther(
    @SerializedName("official-artwork") val officialArtwork: PokemonOfficialArtwork
)

data class PokemonOfficialArtwork(
    val front_default: String
)
