package com.example.shopfront.ui.pizzas.adapter

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.example.shopfront.domain.model.Pizza
import com.example.shopfront.ui.common.App
import com.example.shopfront.ui.pizzafull.PizzaFullFragment

class PizzaVM(application: Application, val data: Pizza) : AndroidViewModel(application) {
    fun onClick(){
        val pizzaFullFragment = PizzaFullFragment()
        val bundle = Bundle()
        bundle.putLong("ARG_PIZZA_ID", data.id ?: 1)
        pizzaFullFragment.arguments = bundle
        getApplication<App>().mainRouter.showPizzaFullInfoFragment(pizzaFullFragment)
    }
}