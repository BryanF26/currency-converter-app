package com.example.currency_converter_app.ui.history

import HistoryViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currency_converter_app.R

class HistoryFragment : Fragment() {

    private lateinit var viewModel: HistoryViewModel
    private lateinit var historyAdapter: HistoryAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewHistory)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set up ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(HistoryViewModel::class.java)

        // Initialize the adapter with data when available
        historyAdapter = HistoryAdapter(emptyList())
        recyclerView.adapter = historyAdapter

        // Observe the LiveData from ViewModel
        viewModel.currencyRateHistory.observe(viewLifecycleOwner) { historyList ->
            // Update the adapter with new data
            historyAdapter.updateData(historyList) // Call updateData method
        }
    }
}
