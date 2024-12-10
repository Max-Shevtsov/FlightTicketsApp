package com.max.flightticketsapp.ui.flightsFragment

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.R
import com.max.flightticketsapp.databinding.FragmentFlightsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FlightsFragment : Fragment() {

    private var _binding: FragmentFlightsBinding? = null

    private val binding get() = _binding!!

    //private val viewModel: FlightsViewModel by viewModels { FlightsViewModel.Factory }
    private val bundle = Bundle()
    private lateinit var adapter: FlightsToConcertAdapter
    //private lateinit var navController: NavController

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        adapter = FlightsToConcertAdapter()
        val dividerItemDecoration = DividerItemDecoration(context, RecyclerView.VERTICAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_drawable))

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

        renderState()
        initListeners()

        return view
    }

    private fun renderState() {
        lifecycleScope.launch(Dispatchers.Main) {
            /* viewModel.flightsUiState.collect { state ->
                 adapter.submitList(state.offers)
             }*/
        }
    }

    private fun initListeners() {
        binding.departure.doOnTextChanged { text, _, _, _ ->
            bundle.putString("departure_town", text.toString())
        }
        binding.departure.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                findNavController().navigate(R.id.navigation_search, bundle)
                return@OnKeyListener true
            }
            false
        })
        binding.arrivale.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                findNavController().navigate(R.id.navigation_search, bundle)
                    binding.arrivale.clearFocus()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}