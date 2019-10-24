package com.example.currencyproject.screens

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyproject.App
import com.example.currencyproject.services.DataBaseService
import com.example.currencyproject.services.NetworkService
import javax.inject.Inject

open abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }
}
