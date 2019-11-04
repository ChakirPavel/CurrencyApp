package com.example.currencyproject.services

import android.util.ArrayMap
import androidx.room.TypeConverter
import com.facebook.common.internal.ImmutableList
import java.util.Arrays.asList
import java.util.stream.Collectors
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken




class ConverterService {
    @TypeConverter
    fun fromString(value: String): ArrayMap<String, Double> {
        val mapType = object : TypeToken<ArrayMap<String, Double>>() {
        }.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStringToArrayMap(map: ArrayMap<String, Double>): String {
        return Gson().toJson(map)
    }

}