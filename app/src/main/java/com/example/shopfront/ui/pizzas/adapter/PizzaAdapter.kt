package com.example.shopfront.ui.pizzas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopfront.databinding.ItemPizzaVhBinding

internal class PizzaAdapter : RecyclerView.Adapter<PizzaVH>() {

    private val pizzasList = mutableListOf<PizzaVM>()

    fun reload(newData: List<PizzaVM>) {
        pizzasList.clear()
        pizzasList.addAll(newData)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaVH {
        return PizzaVH(
            ItemPizzaVhBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: PizzaVH, position: Int) {
        holder.bind(pizzasList[position])
    }
    override fun getItemCount(): Int = pizzasList.size
}