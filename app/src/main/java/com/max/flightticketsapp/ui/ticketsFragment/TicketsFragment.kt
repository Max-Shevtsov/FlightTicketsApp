package com.max.flightticketsapp.ui.ticketsFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.App
import com.max.flightticketsapp.databinding.FragmentTicketsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class TicketsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: TicketsViewModel by viewModels { viewModelFactory }

    private var _binding: FragmentTicketsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: TicketsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketsBinding.inflate(inflater, container, false)
        val view: View = binding.root
        adapter = TicketsAdapter()

        renderState()

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        return view
    }

    private fun renderState() {
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.ticketsUiState.collect {
                adapter.submitList(viewModel.ticketsUiState.value.tickets.tickets)
            }
        }
    }


}