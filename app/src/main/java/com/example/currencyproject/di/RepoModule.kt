package com.example.currencyproject.di

import android.app.Application
import android.content.Context
import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.repositories.RoomDAO.CurrencyDAO
import com.example.currencyproject.repositories.RoomDAO.DataBaseRoom
import com.example.currencyproject.services.AlertService
import com.example.currencyproject.services.NetworkService
import dagger.Module
import dagger.Provides

@Module
class RepoModule {
    @Provides
    fun provideCurrencyRepo(alertService: AlertService, networkService: NetworkService, context: Context, dao: CurrencyDAO): CurrencyRepo {
        return CurrencyRepo(alertService, networkService, context, dao)
    }
}