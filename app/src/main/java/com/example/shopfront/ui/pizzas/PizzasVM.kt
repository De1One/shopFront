package com.example.shopfront.ui.pizzas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shopfront.data.storage.StorageData
import com.example.shopfront.domain.model.Pizza
import com.example.shopfront.ui.common.App
import com.example.shopfront.ui.pizzas.adapter.PizzaVM
import kotlinx.coroutines.launch

class PizzasVM(application: Application) : AndroidViewModel(application) {

    private val pizzasVM: MutableLiveData<List<PizzaVM>> = MutableLiveData()
    private val storage = StorageData()

    init {
        loadPizzas()
    }

    fun getPizzas(): LiveData<List<PizzaVM>> {
        return pizzasVM
    }

    private fun loadPizzas() {
        viewModelScope.launch {
            pizzasVM.postValue(storage.pizzasList().map{PizzaVM(getApplication<App>(),it)})
        }
    }
}