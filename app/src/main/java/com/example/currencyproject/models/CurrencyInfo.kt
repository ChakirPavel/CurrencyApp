package com.example.currencyproject.models

import android.util.ArrayMap

data class CurrencyInfo(
    val base : String,
    val date : String,
    var rates: ArrayMap<String, Double>
)
