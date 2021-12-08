package com.example.shopfront.ui.pizzas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopfront.databinding.FragmentPizzasBinding
import com.example.shopfront.ui.pizzas.adapter.PizzaAdapter

class PizzasFragment: Fragment(){
    private var _binding: FragmentPizzasBinding? = null
    private val binding get() = _binding!!

    private var pizzasAdapter = PizzaAdapter()
    private val pizzasViewModel: PizzasVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPizzasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewPizzas.apply {
            adapter = pizzasAdapter
            layoutManager = LinearLayoutManager(context)
        }

        pizzasViewModel.getPizzas().observe(viewLifecycleOwner) {
            pizzasAdapter.reload(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}