package com.example.clase4ytexample_viewmodel.utils

import com.example.clase4ytexample_viewmodel.domain.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Crea una instancia de Retrofit para interactuar con la API.
//Convertidor de Gson: convierte las respuestas JSON de la API en objetos de Kotlin y viceversa.
object RetrofitInstance {
    val api: ApiInterface by lazy{  //by lazy: se crea la primera vez que se llama
        Retrofit.Builder()
            .baseUrl(Util.Base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}