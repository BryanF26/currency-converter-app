package com.example.currency_converter_app.ui.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency_converter_app.R

class HistoryAdapter(private var historyList: List<CurrencyRateHistory>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fromCurrencyText: TextView = view.findViewById(R.id.tvFromCurrency)
        val toCurrencyText: TextView = view.findViewById(R.id.tvToCurrency)
        val currencyConvertText: TextView = view.findViewById(R.id.tvCurrencyConvert)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = historyList[position]
        holder.fromCurrencyText.text = history.fromCurrency
        holder.toCurrencyText.text = history.toCurrency
        holder.currencyConvertText.text = history.currencyConvert
    }

    override fun getItemCount(): Int = historyList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newHistoryList: List<CurrencyRateHistory>) {
        historyList = newHistoryList
        notifyDataSetChanged() // Notify the adapter to refresh the view
    }
}

