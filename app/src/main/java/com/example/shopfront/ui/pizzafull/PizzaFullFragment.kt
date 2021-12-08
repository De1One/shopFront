package com.example.shopfront.ui.pizzafull

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.shopfront.databinding.FragmentPizzaFullBinding

class PizzaFullFragment : Fragment() {

    private var _binding: FragmentPizzaFullBinding? = null
    private val binding get() = _binding!!

    private val pizzaFullVM: PizzaFullVM by viewModels()

    companion object {
        private const val ARG_PIZZA_ID = "ARG_PIZZA_ID"
        fun newInstance(pizzaId: Long): Fragment {
            return PizzaFullFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_PIZZA_ID, pizzaId)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentPizzaFullBinding.inflate(inflater, container, false)
        binding.viewModel = pizzaFullVM
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong(ARG_PIZZA_ID)
        id?.let(pizzaFullVM::loadData)
        /*
        binding.apply {
            eventDescToolbar.setNavigationOnClickListener { mainRouter.back() }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}