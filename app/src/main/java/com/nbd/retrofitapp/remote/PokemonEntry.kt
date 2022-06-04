package com.nbd.retrofitapp.remote

import com.google.gson.annotations.SerializedName

data class PokemonEntry(
    @SerializedName ("id")
    val id:Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("types")
    val type: List<TypeEntry>,
    @SerializedName("stats")
    val stats:List<StatsEntry>

)

data class TypeEntry(//primer nivel
    @SerializedName("type")
    val type: TypeName
)

data class TypeName(//segundonivel
    @SerializedName("name")
    val name:String
)

data class StatsEntry(//solo un nivel
    @SerializedName("base_stat")
    val base_stat: Int,
    @SerializedName("stat")
    val stat:StatEntry
)
 data class StatEntry(
     @SerializedName("name")
     val stat_value:Int
 )
