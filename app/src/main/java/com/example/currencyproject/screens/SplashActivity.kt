package com.example.currencyproject.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyproject.R
import android.content.Intent
import com.example.currencyproject.screens.currencyList.CurrencyListActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, CurrencyListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
