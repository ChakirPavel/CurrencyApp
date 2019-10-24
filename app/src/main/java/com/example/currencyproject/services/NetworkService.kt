package com.example.currencyproject.services

import android.content.Context
import android.net.ConnectivityManager
import com.example.currencyproject.App
import com.example.currencyproject.models.CurrencyInfo
import retrofit2.Call
import retrofit2.http.GET
import javax.inject.Inject

interface NetworkService {
    @GET("latest?base=RUB")
    fun GetCurrencys(): Call<CurrencyInfo>

    // For future
    //@GET("latest?base={currencyName}")
    //fun GetCurrencys(@Path("currencyName") currencyName: String): Call<List<Repo>>
}