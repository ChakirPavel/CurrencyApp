package com.example.currencyproject.di

import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.screens.currencyList.CurrencyListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    internal fun provideCurrencyListViewModel(currencyRepo: CurrencyRepo): CurrencyListViewModel {
        return CurrencyListViewModel(currencyRepo)
    }

}