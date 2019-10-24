package com.example.currencyproject.di

import com.example.currencyproject.services.DataBaseService
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @Provides
    internal fun provideDataBaseHelper(): DataBaseService {
        return DataBaseService()
    }

}