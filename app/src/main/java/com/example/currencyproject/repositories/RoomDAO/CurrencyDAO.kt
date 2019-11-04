package com.example.currencyproject.repositories.RoomDAO

import androidx.room.*
import com.example.currencyproject.repositories.models.CurrencyInfo


@Dao
interface CurrencyDAO {

    @Query("SELECT * FROM currencyinfo LIMIT 1")
    suspend fun getInfo(): CurrencyInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(info: CurrencyInfo)

    @Update
    suspend fun update(info: CurrencyInfo)

    @Delete
    suspend fun delete(info: CurrencyInfo)
}
