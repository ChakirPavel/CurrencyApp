package com.example.currencyproject.repositories.RoomDAO

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.example.currencyproject.repositories.models.CurrencyInfo


//@Database(entities = [CurrencyInfo::class], version = 1)
//abstract class DataBaseRoom : RoomDatabase() {
//    abstract fun currencyDAO(): CurrencyDAO
//}

@Database(entities = arrayOf(CurrencyInfo::class), version = 3)
abstract class DataBaseRoom : RoomDatabase() {

    abstract fun currencyDAO(): CurrencyDAO


    companion object {
        @Volatile
        private var INSTANCE: DataBaseRoom? = null

        fun getDatabase(context: Context): DataBaseRoom {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBaseRoom::class.java,
                    "my_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}