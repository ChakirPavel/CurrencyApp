package com.example.currencyproject.di

import com.example.currencyproject.services.ConverterService
import com.example.currencyproject.services.NetworkService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ConverterModule {

    @Provides
    internal fun provideConverter(): ConverterService {
        return ConverterService()
    }
}