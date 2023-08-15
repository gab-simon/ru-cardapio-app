package com.rucardapio

import retrofit2.Call
import retrofit2.http.GET

interface GetMenu {
    @GET("cardapios/poli/")
    fun list(): Call<List<MenuEntity>>
}