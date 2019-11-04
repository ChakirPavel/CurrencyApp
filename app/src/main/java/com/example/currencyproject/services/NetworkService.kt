package com.example.currencyproject.services

import android.content.Context
import android.net.ConnectivityManager
import com.example.currencyproject.repositories.models.CurrencyInfo
import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("latest?base=RUB")
    fun GetCurrencys(): Call<CurrencyInfo>
    // For future
    //@GET("latest?base={currencyName}")
    //fun GetCurrencys(@Path("currencyName") currencyName: String): Call<List<Repo>>

}

fun NetworkService.checkConnection(context: Context): Boolean {
    //TODO("Change it and research about best way check connection without create new class only for this")
    val conManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val ni = conManager.activeNetworkInfo
    return ni != null && ni.isConnected
}