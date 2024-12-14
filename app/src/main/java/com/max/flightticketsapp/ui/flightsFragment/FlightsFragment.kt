package com.max.flightticketsapp.ui.flightsFragment

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class FlightsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: FlightsViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentFlightsBinding? = null
    private val binding get() = _binding!!
    private val bundle = Bundle()
    private lateinit var adapter: FlightsToConcertAdapter

    //private lateinit var navController: NavController
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlightsBinding.inflate(inflater, container, false)
        val view: View = binding.root

        adapter = FlightsToConcertAdapter()
        val dividerItemDecoration = DividerItemDecoration(context, RecyclerView.HORIZONTAL)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider_drawable))

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.addItemDecoration(dividerItemDecoration)
        renderState()
        initListeners()

        return view
    }

    private fun setupViewModel() {
    }

    private fun renderState() {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.flightsUiState.collect { state ->
                adapter.submitList(state.offersUi.offersUi)
            }
        }
    }

    private fun initListeners() {
        binding.departure.doOnTextChanged { text, _, _, _ ->
            bundle.putString("departure_town", text.toString())
        }
        binding.departure.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                binding.arrival.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        binding.arrival.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                findNavController().navigate(R.id.navigation_search, bundle)
                binding.arrival.clearFocus()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}