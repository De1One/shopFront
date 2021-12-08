package com.example.shopfront.domain.model

data class PizzaFullInfo(
    val id: Long?,val name: String,val calories: Double?,
    val image: String,val price: Double?,val weight: Double?,
    val diameter: Double?,val composition: String
){
    companion object{
        fun emptyPizzaFullInfo() = PizzaFullInfo(
            null,"",null,"",null,null,null,""
        )
    }
}