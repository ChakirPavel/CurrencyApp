package com.example.currencyproject.adapters

import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyproject.databinding.RvItemCurrencyBinding
import java.util.*


class ListCurrencyAdapter(private var items: ArrayMap<String, Double>,
                          private var listener: OnItemClickListener)
    : RecyclerView.Adapter<ListCurrencyAdapter.ViewHolder>() {

    private var valueCalculate: Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemCurrencyBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    fun updateList(items: ArrayMap<String, Double>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun updateValueCurrency( valueCalculate: Int?)
    {
        this.valueCalculate = if(valueCalculate != null) valueCalculate else 1
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
          currency = CurrencyItem(items.keyAt(position),
                                  "%.2f".format(valueCalculate.toDouble() * items.valueAt(position)))
          executePendingBindings()
        }
    }

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(var binding: RvItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root)

    inner class CurrencyItem (var currencyName: String, var currencyValue: String) {
        val currencyFullName : String
        get() {
            return Currency.getInstance(currencyName).displayName
        }
    }

}