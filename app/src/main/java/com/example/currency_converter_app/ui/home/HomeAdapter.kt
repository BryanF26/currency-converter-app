package com.example.currency_converter_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.currency_converter_app.R

class HomeAdapter(private val homeList: List<CurrencyRateHome>, private val fragment: Fragment) :
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
        val resourceId = holder.itemView.resources.getIdentifier(home.flagName, "drawable", holder.itemView.context.packageName)
        holder.flagNameText.setImageResource(resourceId)
        holder.currencyText.text = home.currency
        holder.fullNameCurrencyText.text = home.fullNameCurrency
        holder.rateText.text = home.rate

        // Handle click event directly here
        holder.itemView.setOnClickListener {
            // Navigate to the DashboardFragment and pass data
            val bundle = Bundle().apply {
                putString("fromCurrency", home.currency)
                putString("toCurrency", home.rate.takeLast(3)) // Example to get the last 3 characters
                putString("rate", home.rate)
            }

            // Assuming you have a way to get the Navigation Controller from the context
            fragment.findNavController().navigate(R.id.navigation_dashboard, bundle)
        }
    }

    override fun getItemCount(): Int = homeList.size
}
