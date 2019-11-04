package com.example.currencyproject.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.currencyproject.repositories.RoomDAO.CurrencyDAO
import com.example.currencyproject.repositories.RoomDAO.DataBaseRoom
import com.example.currencyproject.services.DataBaseService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    internal fun provideDataBase(context: Context): DataBaseRoom {
        return DataBaseRoom.getDatabase(context)
    }

    @Provides
    internal fun provideCurrencyDAO(db: DataBaseRoom): CurrencyDAO {
        return db.currencyDAO()
    }

}