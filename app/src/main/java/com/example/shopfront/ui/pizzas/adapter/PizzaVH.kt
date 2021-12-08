package com.example.shopfront.ui.pizzas.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.shopfront.databinding.ItemPizzaVhBinding
import com.example.shopfront.BR
import com.example.shopfront.R
import com.squareup.picasso.Picasso

internal class PizzaVH(private val binding: ItemPizzaVhBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(pizzaVM: PizzaVM){
        binding.apply {
            setVariable(BR.viewModel, pizzaVM)
            pizzaName.text = pizzaVM.data.name
            pizzaWeight.text = "${pizzaVM.data.weight.toString()} гр."
            pizzaCalories.text = "${pizzaVM.data.calories.toString()} Ккал"
            pizzaPrice.text = "${pizzaVM.data.price.toString()} руб."
            Picasso.get()
                .load("http://192.168.1.67:8080/${pizzaVM.data.image}")
                .placeholder(R.drawable.pizza)
                .error(R.drawable.pizza)
                .into(pizzaImage)
        }

    }
}