package com.example.currencyproject.screens.currencyList

import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.ArrayMap
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyproject.App
import com.example.currencyproject.R
import com.example.currencyproject.adapters.ListCurrencyAdapter
import com.example.currencyproject.databinding.ActivityCurrencyListBinding
import com.example.currencyproject.models.CurrencyInfo
import com.example.currencyproject.screens.BaseActivity
import javax.inject.Inject

class CurrencyListActivity : BaseActivity(), ListCurrencyAdapter.OnItemClickListener {

    override fun getLayoutId(): Int = R.layout.activity_currency_list

    @Inject
    lateinit var currencyListViewModel: CurrencyListViewModel

    lateinit var binding : ActivityCurrencyListBinding
    val mainHandler = Handler(Looper.getMainLooper())
    val adapter = ListCurrencyAdapter(ArrayMap<String, Double>(), this );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)

        // region bindings

        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.viewModel = currencyListViewModel
        binding.executePendingBindings()

        binding.rvCurrencys.layoutManager = LinearLayoutManager(this)
        binding.rvCurrencys.adapter = adapter
        currencyListViewModel.valueCurrency.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                adapter.updateValueCurrency(binding.editValueCurrency.text.toString().toIntOrNull())
            }
        })
        currencyListViewModel.currencyInfo.observe(this,
            Observer<CurrencyInfo> { it?.let{ adapter.updateList(it.rates) } })


        // endregion

        // I will stop it after onStop, if need.
        mainHandler.post(object : Runnable {
            override fun run() {
                currencyListViewModel.loadCurrencys();
                mainHandler.postDelayed(this, 2000)
            }
        })
    }


    override fun onItemClick(position: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
