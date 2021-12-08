package com.example.shopfront.ui.common

import android.app.Application
import com.example.shopfront.ui.main.MainRouter

class App : Application() {

    lateinit var mainRouter: MainRouter

    override fun onCreate() {
        super.onCreate()
    }
}