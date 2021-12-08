package com.example.shopfront.data.network

import com.example.shopfront.data.network.service.PizzaService
import com.example.shopfront.data.network.service.PizzaServiceAPI
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object AppNetwork {
    private val gson = GsonBuilder()
        .create()

    private val okHttpClient= OkHttpClient().newBuilder()
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("http://192.168.1.67:8080/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val pizzaService by lazy {
        val pizzaServiceApi = retrofit.create(PizzaServiceAPI::class.java)
        PizzaService(pizzaServiceApi)
    }
}