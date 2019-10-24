package com.example.currencyproject

import android.app.Application
import com.example.currencyproject.di.AppComponent
import com.example.currencyproject.di.ApplicationModule
import com.example.currencyproject.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}