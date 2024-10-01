package com.example.currency_converter_app.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.currency_converter_app.R

class CurrencyAdapter(context: Context, currencies: List<Currency>) :
    ArrayAdapter<Currency>(context, 0, currencies) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val currency = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.currency_item, parent, false)

        val flagImageView: ImageView = view.findViewById(R.id.flagImageView)
        val currencyTextView: TextView = view.findViewById(R.id.currencyCodeTextView)

        currency?.let {
            flagImageView.setImageResource(it.flag)
            currencyTextView.text = it.currencyCode
        }

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }
}
