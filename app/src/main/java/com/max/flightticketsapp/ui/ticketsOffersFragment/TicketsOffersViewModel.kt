package com.max.flightticketsapp.ui.ticketsOffersFragment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicketsOffersViewModel: ViewModel() {
    private val _ticketsOffersUiState: MutableStateFlow<TicketsOffersUiState> =
        MutableStateFlow(TicketsOffersUiState())
    val ticketsOffersUiState: StateFlow<TicketsOffersUiState> = _ticketsOffersUiState.asStateFlow()
}