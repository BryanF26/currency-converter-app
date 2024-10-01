package com.example.currency_converter_app.ui.dashboard

import DashboardViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.currency_converter_app.R

class DashboardFragment : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var viewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        spinner1 = view.findViewById(R.id.spinner1)
        spinner2 = view.findViewById(R.id.spinner2)

        val currencyList = listOf(
            Currency("USD", R.drawable.flag_us),
            Currency("EUR", R.drawable.flag_eur),
            Currency("IDR", R.drawable.flag_ind)
        )

        val adapter = CurrencyAdapter(requireContext(), currencyList)
        spinner1.adapter = adapter
        spinner2.adapter = adapter
    }
}
