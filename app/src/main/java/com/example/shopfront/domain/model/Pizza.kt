package com.example.shopfront.domain.model

data class Pizza(
    val id: Long?,val name: String,val calories: Double?,
    val image: String,val price: Double?,val weight: Double?,
    val diameter: Double?
    ){
    companion object{
        fun emptyPizza() =
            Pizza(null,"",null,"",null,null,null)
    }
}
