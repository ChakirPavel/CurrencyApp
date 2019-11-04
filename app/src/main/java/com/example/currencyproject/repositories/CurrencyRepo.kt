package com.example.currencyproject.repositories

import android.content.Context
import android.util.ArrayMap
import com.example.currencyproject.repositories.RoomDAO.CurrencyDAO
import com.example.currencyproject.repositories.RoomDAO.DataBaseRoom
import com.example.currencyproject.repositories.models.CurrencyInfo
import com.example.currencyproject.services.AlertService
import com.example.currencyproject.services.NetworkService
import com.example.currencyproject.services.checkConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.util.*

class CurrencyRepo(private val alertController: AlertService,
                   private val networkService: NetworkService,
                   private val context: Context,
                   private val currencyDAO: CurrencyDAO) {

    fun getLocalCurrencys(): CurrencyInfo {
        lateinit var info: CurrencyInfo
        runBlocking {
            info = currencyDAO.getInfo()
        }
        if(info == null)
            info = CurrencyInfo("RUB", Calendar.getInstance().time.toString(), ArrayMap())

        return info
    }

    private fun getRemoteCurrencys(): CurrencyInfo {
        lateinit var info: CurrencyInfo
        runBlocking {
            withContext(Dispatchers.IO) {
                var response = networkService.GetCurrencys().execute()
                if (response.isSuccessful && response.errorBody() == null) {
                    info = response.body()!!
                    info.date = Calendar.getInstance().time.toString()
                    currencyDAO.insert(info)
                } else {
                    alertController.ShowMessageDialog(response.errorBody().toString())
                }
            }
        }

        return info;
    }

    fun getCurrencys(): CurrencyInfo {
        if(networkService.checkConnection(context))
            return getRemoteCurrencys()
        else
            return getLocalCurrencys()
    }
}