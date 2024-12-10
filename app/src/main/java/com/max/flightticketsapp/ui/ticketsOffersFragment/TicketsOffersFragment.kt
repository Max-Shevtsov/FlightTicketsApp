package com.max.flightticketsapp.ui.ticketsOffersFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.max.flightticketsapp.R
import com.max.flightticketsapp.databinding.FragmentFlightsBinding
import com.max.flightticketsapp.databinding.FragmentSearchBinding
import com.max.flightticketsapp.databinding.FragmentTicketsOffersBinding
import com.max.flightticketsapp.ui.searchFragment.RecomendationAdapter
import com.max.flightticketsapp.ui.searchFragment.SearchViewModel


class TicketsOffersFragment : Fragment() {


    private var _binding: FragmentTicketsOffersBinding? = null

    private val binding get() = _binding!!

    private val viewModel: TicketsOffersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsOffersBinding.inflate(inflater, container, false)
        val view: View = binding.root

        return view
    }


}