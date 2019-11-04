package com.example.currencyproject.screens.currencyList

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyproject.App
import com.example.currencyproject.repositories.models.CurrencyInfo
import com.example.currencyproject.repositories.CurrencyRepo
import com.example.currencyproject.repositories.RoomDAO.DataBaseRoom
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.runBlocking

class CurrencyListViewModel(private val currencyRepo: CurrencyRepo) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var valueCurrency = ObservableField("1")
    val isLoading = ObservableField(true)

    var currencyInfo = MutableLiveData<CurrencyInfo>()

    fun loadCurrencys() {
        this.currencyInfo.value = currencyRepo.getCurrencys()
        this.isLoading.set(false)
    }

}