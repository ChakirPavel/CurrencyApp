package com.example.currencyproject.repositories.models

import android.util.ArrayMap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.currencyproject.services.ConverterService


@Entity(tableName = "CurrencyInfo")
@TypeConverters(ConverterService::class)
data class CurrencyInfo(
    @PrimaryKey val base : String,
    var date : String,
    var rates: ArrayMap<String, Double>
)

//@Entity(tableName = "CurrencyInfoTest")
//data class CurrencyInfoTest(
//    @PrimaryKey @ColumnInfo(name = "test")val test : String
//)
