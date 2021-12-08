package com.example.shopfront.data.network.model

import java.math.BigDecimal

data class PizzaBE(
    val id: Long?,val name: String,val calories: BigDecimal?,
    val image: String,val price: BigDecimal?,val weight: BigDecimal?,
    val diameter: BigDecimal?
){

}