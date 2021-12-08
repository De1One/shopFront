package com.example.shopfront.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopfront.R
import com.example.shopfront.databinding.ActivityMainBinding
import com.example.shopfront.ui.common.App
import com.example.shopfront.ui.pizzas.PizzasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val mainVM: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).mainRouter = MainRouter(supportFragmentManager)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //if (savedInstanceState == null) updateMainContent(EventsFragment())
        supportFragmentManager.beginTransaction().replace(R.id.main_frame, PizzasFragment()).commit()
    }
}