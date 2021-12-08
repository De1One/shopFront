package com.example.shopfront.ui.pizzafull

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopfront.R
import com.example.shopfront.ui.common.App
import kotlinx.coroutines.launch
import com.example.shopfront.data.storage.StorageData
import com.example.shopfront.domain.model.PizzaFullInfo
import com.squareup.picasso.Picasso

@BindingAdapter("app:picasso")
fun image(view: ImageView, path: String?) {
    Picasso.get().load("http://192.168.1.67:8080/${path}").placeholder(R.drawable.pizza)
        .error(R.drawable.pizza)
        .into(view)
}
class PizzaFullVM (application: Application) : AndroidViewModel(application) {

    private var pizzaFull = PizzaFullInfo.emptyPizzaFullInfo()
    private val storageNetData = StorageData()

    fun loadData(pizzaId: Long){
        viewModelScope.launch {
            pizzaFull = storageNetData.pizza(pizzaId)
            pizzaFull.run{
                nameObs.set(name)
                imageObs.set(image)
                priceObs.set(price.toString())
                weightObs.set(weight.toString())
                caloriesObs.set(calories.toString())
                compositionObs.set(composition)
                diameterObs.set(diameter.toString())
            }
        }
    }

    val nameObs = object : ObservableField<String>(){
        override fun get(): String?{
            return pizzaFull.name
        }
    }

    val caloriesObs = object : ObservableField<String>(){
        override fun get(): String? {
            return "${pizzaFull.calories.toString()} Ккал"
        }
    }

    val imageObs = object : ObservableField<String>(){
        override fun get(): String?{
            return pizzaFull.image
        }
    }

    val priceObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${pizzaFull.price.toString()} руб."
        }
    }

    val weightObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "${pizzaFull.weight.toString()} гр."
        }
    }

    val compositionObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "Состав:\n${pizzaFull.composition}"
        }
    }

    val diameterObs = object : ObservableField<String>(){
        override fun get(): String?{
            return "Диаметер: ${pizzaFull.diameter} см"
        }
    }
    
    private fun closeView() {
        getApplication<App>().mainRouter.back()
    }
}