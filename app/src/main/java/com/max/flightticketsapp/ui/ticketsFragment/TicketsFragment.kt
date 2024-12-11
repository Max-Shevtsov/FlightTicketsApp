package com.max.flightticketsapp.ui.ticketsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.R
import com.max.flightticketsapp.databinding.FragmentFlightsBinding
import com.max.flightticketsapp.databinding.FragmentSearchBinding
import com.max.flightticketsapp.databinding.FragmentTicketsBinding
import com.max.flightticketsapp.databinding.FragmentTicketsOffersBinding
import com.max.flightticketsapp.ui.searchFragment.RecomendationAdapter
import com.max.flightticketsapp.ui.searchFragment.SearchViewModel


class TicketsFragment : Fragment() {


    private var _binding: FragmentTicketsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: TicketsAdapter
    private val viewModel: TicketsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        adapter = TicketsAdapter()
        adapter.submitList(viewModel.ticketsUiState.value.tickets)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        return view
    }


}