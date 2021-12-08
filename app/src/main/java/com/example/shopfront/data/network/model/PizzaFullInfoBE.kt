package com.example.shopfront.data.network.model

import java.math.BigDecimal

class PizzaFullInfoBE (
    val id: Long?, val name: String, val calories: BigDecimal?,
    val image: String, val price: BigDecimal?, val weight: BigDecimal?,
    val diameter: BigDecimal?, val composition: String
    ){
        companion object{
            fun emptyPizzaFullInfoBE() = PizzaFullInfoBE(
                null,"",null,"",null,null,null,""
            )
        }
    }