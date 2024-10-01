package com.example.currency_converter_app.ui.dashboard

import DashboardViewModel
import HistoryViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.currency_converter_app.R


class DashboardFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel
    private lateinit var viewModel: DashboardViewModel
    private lateinit var amountEditText: EditText
    private lateinit var convertedAmountTextView: TextView
    private lateinit var getExchangeRateButton: Button
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    @SuppressLint("DefaultLocale")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyViewModel = ViewModelProvider(requireActivity()).get(HistoryViewModel::class.java)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        amountEditText = view.findViewById(R.id.amountEditText)
        convertedAmountTextView = view.findViewById(R.id.convertedAmountTextView)
        getExchangeRateButton = view.findViewById(R.id.getExchangeRateButton)
        spinnerFrom = view.findViewById(R.id.spinnerFrom)
        spinnerTo = view.findViewById(R.id.spinnerTo)

        val currencyList = listOf(
            Currency("USD", R.drawable.flag_usd),
            Currency("EUR", R.drawable.flag_eur),
            Currency("IDR", R.drawable.flag_idr)
        )

        val adapter = CurrencyAdapter(requireContext(), currencyList)
        spinnerFrom.adapter = adapter
        spinnerTo.adapter = adapter

        setSpinnerDefaults(currencyList)

        amountEditText.setText("1")

        convertedAmountTextView.text = "1 USD = 15196.90 IDR"

        getExchangeRateButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDoubleOrNull()
            if (amount != null && amount > 0) {
                val fromCurrency = (spinnerFrom.selectedItem as Currency).currencyCode
                val toCurrency = (spinnerTo.selectedItem as Currency).currencyCode

                if (fromCurrency == toCurrency) {
                    convertedAmountTextView.text = "Please select different currencies"
                    return@setOnClickListener
                }

                val result = viewModel.getExchangeRate(fromCurrency, toCurrency, amount)

                convertedAmountTextView.text = String.format(
                    "%.2f %s = %.2f %s",
                    amount, fromCurrency, result, toCurrency
                )
                Toast.makeText(requireContext(), "Exchange Successfully!", Toast.LENGTH_SHORT).show()
                historyViewModel.addCurrencyRateHistory(fromCurrency, toCurrency, convertedAmountTextView.text.toString())
            } else {
                convertedAmountTextView.text = "Please enter a valid amount"
            }
        }
    }

    private fun setSpinnerDefaults(currencyList: List<Currency>) {
        val usdIndex = currencyList.indexOfFirst { it.currencyCode == "USD" }
        val idrIndex = currencyList.indexOfFirst { it.currencyCode == "IDR" }

        if (usdIndex >= 0) {
            spinnerFrom.setSelection(usdIndex)
        }
        if (idrIndex >= 0) {
            spinnerTo.setSelection(idrIndex)
        }
    }
}
