package com.example.shopfront.data.network.service

import com.example.shopfront.data.network.model.PizzaFullInfoBE
import com.example.shopfront.data.network.model.PizzasListBE
import retrofit2.Response

internal class PizzaService(
    private val apiService: PizzaServiceAPI
) {
    suspend fun getPizzaList(): Response<PizzasListBE> = apiService.getPizzaList()
    suspend fun getPizzaById(id : Long): Response<PizzaFullInfoBE> = apiService.getPizzaById(id)
}