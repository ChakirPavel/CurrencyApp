package com.example.currencyproject.di

import android.content.Context
import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.services.AlertService
import com.example.currencyproject.services.NetworkService
import dagger.Module
import dagger.Provides

@Module
class RouterModule {

    @Provides
    fun provideAlertService(context: Context): AlertService {
        return AlertService(context)
    }
}