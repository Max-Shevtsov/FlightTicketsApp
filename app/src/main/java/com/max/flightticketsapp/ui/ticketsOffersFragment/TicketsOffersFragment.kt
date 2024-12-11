package com.max.flightticketsapp.ui.ticketsOffersFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.R
import com.max.flightticketsapp.databinding.FragmentFlightsBinding
import com.max.flightticketsapp.databinding.FragmentSearchBinding
import com.max.flightticketsapp.databinding.FragmentTicketsOffersBinding
import com.max.flightticketsapp.ui.searchFragment.RecomendationAdapter
import com.max.flightticketsapp.ui.searchFragment.SearchViewModel


class TicketsOffersFragment : Fragment() {


    private var _binding: FragmentTicketsOffersBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: TicketsoffersAdapter
    private val viewModel: TicketsOffersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsOffersBinding.inflate(inflater, container, false)
        val view: View = binding.root

        adapter = TicketsoffersAdapter(viewModel.ticketsOffersUiState.value.ticketsOffers)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        return view
    }

    override fun onResume() {
        super.onResume()
        getArgsFromFlightsFragment()
    }

    private fun getArgsFromFlightsFragment() {

        binding.departure.setText(arguments?.getString("departure_town"))
        binding.arrival.setText(arguments?.getString("arrival_town"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}