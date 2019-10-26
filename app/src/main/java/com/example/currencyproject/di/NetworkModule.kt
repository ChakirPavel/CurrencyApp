package com.example.currencyproject.di

import android.app.Application
import android.content.Context
import com.example.currencyproject.App
import com.example.currencyproject.BuildConfig
import com.example.currencyproject.services.NetworkManager
import com.example.currencyproject.services.NetworkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    internal fun provideNetworkService(): NetworkService {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
        return retrofit.create(NetworkService::class.java)
    }
}