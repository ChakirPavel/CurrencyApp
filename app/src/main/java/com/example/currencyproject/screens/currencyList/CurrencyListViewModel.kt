package com.example.currencyproject.screens.currencyList

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyproject.models.CurrencyInfo
import com.example.currencyproject.repositories.CurrencyRepo
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyListViewModel(private val currencyRepo: CurrencyRepo) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var valueCurrency = ObservableField("1")
    var lastUpdate = ObservableField("")
    val isLoading = ObservableField(true)

    var currencyInfo = MutableLiveData<CurrencyInfo>()

    fun loadCurrencys() {
        currencyRepo
            .getCurrencys(object : Callback<CurrencyInfo> {
                override fun onFailure(call: Call<CurrencyInfo>, t: Throwable) {
                    // Show error.
                }

                override fun onResponse(
                    call: Call<CurrencyInfo>,
                    response: Response<CurrencyInfo>
                ) {
                    currencyInfo.value = response.body()!!
                    isLoading.set(false)
                }
            })
    }
}