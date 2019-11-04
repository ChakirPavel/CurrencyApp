package com.example.currencyproject.services

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class AlertService(val context: Context){

    fun ShowMessageDialog(message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Alert!")
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        builder.show()
    }
}