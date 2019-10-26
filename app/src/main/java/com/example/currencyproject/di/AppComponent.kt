package com.example.currencyproject.di

import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.screens.BaseActivity
import com.example.currencyproject.screens.currencyList.CurrencyListActivity
import dagger.Component

@Component(modules = arrayOf(
    NetworkModule::class, DataBaseModule::class, RepoModule::class,
    ViewModelsModule::class, ApplicationModule::class, ConverterModule::class
    ))
interface AppComponent {
    fun inject(activity: CurrencyListActivity)
    // Question for reviewer:
    // If we use BaseActivity, all injects doesn't work.
    // Dagger understood what field we need inject from struct class, correct?
    // How we will create universal method for inject?
    // Or it's normal write fun for every activity?
}