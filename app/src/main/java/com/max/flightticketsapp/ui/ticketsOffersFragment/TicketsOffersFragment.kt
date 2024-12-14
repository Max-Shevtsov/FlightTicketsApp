package com.max.flightticketsapp.ui.ticketsOffersFragment

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.App
import com.max.flightticketsapp.R
import com.max.flightticketsapp.databinding.FragmentFlightsBinding
import com.max.flightticketsapp.databinding.FragmentSearchBinding
import com.max.flightticketsapp.databinding.FragmentTicketsOffersBinding
import com.max.flightticketsapp.ui.flightsFragment.FlightsViewModel
import com.max.flightticketsapp.ui.searchFragment.RecomendationAdapter
import com.max.flightticketsapp.ui.searchFragment.SearchViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class TicketsOffersFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: TicketsOffersViewModel by viewModels { viewModelFactory }
    private var _binding: FragmentTicketsOffersBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: TicketsOffersAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsOffersBinding.inflate(inflater, container, false)
        val view: View = binding.root

        adapter = TicketsOffersAdapter()

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        initListeners()
        renderState()

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

    private fun renderState() {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.ticketsOffersUiState.collect {
                adapter.submitList(
                    viewModel.ticketsOffersUiState.value.ticketsOffers.ticketsOffers.take(
                        3
                    )
                )
            }
        }
    }

    private fun initListeners() {
        binding.showAllTickets.setOnClickListener {
            findNavController().navigate(R.id.navigation_tickets)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}