package com.example.currencyproject

import android.app.Application
import androidx.room.Room
import com.example.currencyproject.di.AppComponent
import com.example.currencyproject.di.ApplicationModule
import com.example.currencyproject.di.DaggerAppComponent
import com.example.currencyproject.di.DataBaseModule
import com.example.currencyproject.repositories.RoomDAO.DataBaseRoom

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        //component = DaggerAppComponent.builder().applicationModule(ApplicationModule(this)).build()

        var componentBuilder = DaggerAppComponent.builder()
        componentBuilder.applicationModule(ApplicationModule(this))

        component = componentBuilder.build()
    }



    companion object {
        lateinit var component: AppComponent
        lateinit var database: DataBaseRoom
    }
}