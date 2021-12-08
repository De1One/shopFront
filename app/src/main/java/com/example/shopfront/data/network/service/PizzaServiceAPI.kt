package com.example.shopfront.data.network.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.shopfront.data.network.model.PizzaFullInfoBE
import com.example.shopfront.data.network.model.PizzasListBE

internal interface PizzaServiceAPI {

    @GET("getPizzas")
    suspend fun getPizzaList() : Response<PizzasListBE>

    @GET("pizza/{id}")
    suspend fun getPizzaById(@Path("id") id: Long): Response<PizzaFullInfoBE>
}