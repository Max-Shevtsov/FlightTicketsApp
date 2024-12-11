package com.max.flightticketsapp.ui.searchFragment

import android.app.Dialog
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.max.flightticketsapp.R
import com.max.flightticketsapp.databinding.FragmentSearchBinding

class SearchFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: RecomendationAdapter
    private val bundle = Bundle()
    private val viewModel: SearchViewModel by viewModels()
    override fun getTheme() = R.style.AppBottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        if (dialog.window != null) {
            dialog.window!!.setGravity(Gravity.BOTTOM)
            dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            dialog.setCancelable(false)
        }

        dialog.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                val behaviour = BottomSheetBehavior.from(it)
                setupFullHeight(it)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }

        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view: View = binding.root

        adapter = RecomendationAdapter(viewModel.searchUiState.value.recomendations)

        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        initListeners()

        return view
    }

    override fun onResume() {
        super.onResume()
        getArgsFromFlightsFragment()
    }

    private fun getArgsFromFlightsFragment() {

        binding.departure.setText(arguments?.getString("departure_town"))
        binding.arrival.requestFocus()
        dialog?.window?.setSoftInputMode(SOFT_INPUT_STATE_ALWAYS_VISIBLE)
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    private fun initListeners() {
        binding.departure.doOnTextChanged { text, _, _, _ ->
            bundle.putString("departure_town", text.toString())
        }
        binding.arrival.doOnTextChanged { text, _, _, _ ->
            bundle.putString("arrival_town", text.toString())
        }
        binding.departure.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                binding.arrival.requestFocus()
                return@OnKeyListener true
            }
            false
        })
        binding.arrival.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                findNavController().navigate(R.id.navigation_ticketsOffers, bundle)
                return@OnKeyListener true
            }
            false
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}