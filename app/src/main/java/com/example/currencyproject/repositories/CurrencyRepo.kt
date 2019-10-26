package com.example.currencyproject.repositories

import android.util.ArrayMap
import android.util.Log
import com.example.currencyproject.models.CurrencyInfo
import com.example.currencyproject.services.NetworkManager
import com.example.currencyproject.services.NetworkService
import io.reactivex.Observable
import io.reactivex.Single
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit

class CurrencyRepo(private val networkManager: NetworkManager, val networkService: NetworkService) {

    private val localDataSource = CurrencyLocalRepo()
    private val remoteDataSource = CurrencyRemoteRepo()
    // I'm not sure about best way.
    // I will create one repo IRepositories and recreate it when connection is lost. Which is good practice?

    fun getCurrencys(callBack: Callback<CurrencyInfo>) {
        if (networkManager.isConnectedToInternet()) {
            remoteDataSource.getData().enqueue(callBack)
        }
        else {
            // Not completed.
            // Get data from local database.
        }
    }


    private inner class CurrencyLocalRepo //: IRepositories<CurrencyInfo>
    {
        fun getData(): Observable<CurrencyInfo> {
            var arrayList = CurrencyInfo("First from remote", "Owner 1", ArrayMap<String, Double>())
            return Observable.just(arrayList)
        }

        fun setData()
        {
            //Save Data
        }
    }

    private inner class CurrencyRemoteRepo //: IRepositories<CurrencyInfo>
     {
        fun getData() : Call<CurrencyInfo> {
            return networkService.GetCurrencys()
        }
    }
}

// Only for practice
//interface IRepositories<T> {
//    fun getData(): Observable<T>
//}