package com.example.currencyproject.di

import android.app.Application
import android.content.Context
import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.services.NetworkManager
import com.example.currencyproject.services.NetworkService
import dagger.Module
import dagger.Provides

@Module
class RepoModule() {

    @Provides
    fun provideNetworkManager(context: Context): NetworkManager {
        return NetworkManager(context)
    }

    @Provides
    fun provideCurrencyRepo(networkManager: NetworkManager, networkService: NetworkService): CurrencyRepo {
        return CurrencyRepo(networkManager, networkService)
    }
}

@Module
class ApplicationModule(private val application: Application) {
    @Provides
    fun provideContext(): Context {
        return application
    }
}