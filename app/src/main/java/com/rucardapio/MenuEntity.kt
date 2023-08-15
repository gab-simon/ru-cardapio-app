package com.rucardapio

import com.google.gson.annotations.SerializedName
import java.util.*

class MenuEntity(
    @SerializedName("ruNome")
    val ruNome: String = "",

    @SerializedName("data")
    val data: String = "",

    @SerializedName("cafe")
    val cafe: MealEntity = MealEntity(),

    @SerializedName("almoco")
    val almoco: MealEntity = MealEntity(),

    @SerializedName("jantar")
    val jantar: MealEntity = MealEntity()
)

class MealEntity(
    @SerializedName("tipo")
    val tipo: String = "",

    @SerializedName("pratos")
    val pratos: List<DishEntity> = emptyList()
)

class DishEntity(
    @SerializedName("nome")
    val nome: String = "",

    @SerializedName("alergenos")
    val alergenos: List<String> = emptyList(),

    @SerializedName("vegano")
    val vegano: Boolean = false
)