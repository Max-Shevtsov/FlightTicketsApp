package com.max.flightticketsapp.ui.ticketsFragment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TicketsViewModel: ViewModel() {
    private val _ticketsUiState: MutableStateFlow<TicketsUiState> =
        MutableStateFlow(TicketsUiState())
    val ticketsUiState: StateFlow<TicketsUiState> = _ticketsUiState.asStateFlow()
}