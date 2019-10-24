package com.example.currencyproject.adapters

import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyproject.databinding.RvItemCurrencyBinding
import com.example.currencyproject.models.CurrencyInfo
import java.text.DecimalFormat
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

    fun updateList(items:  ArrayMap<String, Double>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun updateValueCurrency( valueCalculate: Int?)
    {
        this.valueCalculate = if(valueCalculate != null) valueCalculate else 1
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(
        items.keyAt(position),
        items.values.elementAt(position),
        this.valueCalculate,
        listener)

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: RvItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currencyName:String , currencyValue: Double, valueCalculate: Int, listener: OnItemClickListener?) {
            binding.txtCurrencyName.text = currencyName
            binding.txtValueCurrency.text = "%.2f".format(valueCalculate.toDouble() * currencyValue)
            binding.txtCurrencyInfo.text = Currency.getInstance(currencyName).displayName
            // Not completed.
            if (listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
            }

            binding.executePendingBindings()
        }
    }
}