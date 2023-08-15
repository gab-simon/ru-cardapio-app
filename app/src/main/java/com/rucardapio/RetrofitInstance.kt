package com.rucardapio

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private lateinit var INSTANCE: Retrofit
        private const val BASE_URL = "http://10.0.2.2:3000/"
        private fun getRetrofitInstance(): Retrofit {
            val http = OkHttpClient.Builder()
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder().baseUrl(BASE_URL).client(http.build())
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }

            return INSTANCE
        }

        fun createMenuService(): GetMenu {
            return getRetrofitInstance().create(GetMenu::class.java)
        }
    }
}