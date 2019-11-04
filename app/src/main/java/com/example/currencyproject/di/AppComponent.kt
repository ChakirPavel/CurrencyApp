package com.example.currencyproject.di

import android.app.Application
import android.content.Context
import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.screens.BaseActivity
import com.example.currencyproject.screens.currencyList.CurrencyListActivity
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = arrayOf(
    NetworkModule::class,       DataBaseModule::class,      RepoModule::class,
    ViewModelsModule::class,    ApplicationModule::class,   ConverterModule::class,
    RouterModule::class
))

interface AppComponent {
    fun inject(activity: CurrencyListActivity)
}

@Module
class ApplicationModule(private val application: Application) {
    @Provides
    fun provideContext(): Context {
        return application
    }
}