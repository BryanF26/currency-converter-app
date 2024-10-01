package com.example.currency_converter_app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency_converter_app.R

class HomeAdapter(private val homeList: List<CurrencyRateHome>) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagNameText: ImageView = view.findViewById(R.id.tvFlagName)
        val currencyText: TextView = view.findViewById(R.id.tvCurrencyHome)
        val fullNameCurrencyText: TextView = view.findViewById(R.id.tvFullNameCurrencyHome)
        val rateText: TextView = view.findViewById(R.id.tvRateHome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val home = homeList[position]
        val context = holder.flagNameText.context
        val resourceId = context.resources.getIdentifier(home.flagName, "drawable", context.packageName)
        holder.flagNameText.setImageResource(resourceId)
        holder.currencyText.text = home.currency
        holder.fullNameCurrencyText.text = home.fullNameCurrency
        holder.rateText.text = home.rate
    }

    override fun getItemCount(): Int = homeList.size
}

