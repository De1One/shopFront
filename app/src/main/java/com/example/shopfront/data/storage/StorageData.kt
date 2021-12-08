package com.example.shopfront.data.storage

import com.example.shopfront.data.network.AppNetwork
import com.example.shopfront.data.network.model.PizzaFullInfoBE
import com.example.shopfront.domain.model.Pizza
import com.example.shopfront.domain.model.PizzaFullInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StorageData(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val pizzaService = AppNetwork.pizzaService

    suspend fun pizzasList(): List<Pizza> = withContext(defaultDispatcher){
        val response = pizzaService.getPizzaList()

        val cakeList = if(response.isSuccessful){
            response.body()?.pizza_list ?: listOf()
        } else listOf()

        cakeList.map{
            with(it){ Pizza(id, name, calories?.toDouble(), image,
                price?.toDouble(), weight?.toDouble(),diameter?.toDouble()) }
        }
    }

    suspend fun pizza(id: Long): PizzaFullInfo = withContext(defaultDispatcher){
        val response = pizzaService.getPizzaById(id)

        val pizza = if(response.isSuccessful){
            response.body() ?: PizzaFullInfoBE.emptyPizzaFullInfoBE()
        } else PizzaFullInfoBE.emptyPizzaFullInfoBE()

        var pizzaFullInfo: PizzaFullInfo
        pizza.apply {
            pizzaFullInfo = PizzaFullInfo(id, name, calories?.toDouble(), image, price?.toDouble(),
                weight?.toDouble(), diameter?.toDouble(),composition)
        }
        pizzaFullInfo
    }
}