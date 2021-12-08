package com.example.shopfront.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.shopfront.R

class MainRouter(
    private val fragmentManager: FragmentManager
) {

    fun showPizzaFullInfoFragment(fragment: Fragment){
        fragmentManager.beginTransaction()
            .replace(R.id.main_frame,fragment)
            .addToBackStack(null)
            .commit()
    }

    fun back() = fragmentManager.popBackStack()
}