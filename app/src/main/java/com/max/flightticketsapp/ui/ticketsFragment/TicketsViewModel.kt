package com.max.flightticketsapp.ui.ticketsFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.booking_flights_domain.repositories.TicketsRepository
import com.max.flightticketsapp.data.mappers.toTicketsUi
import com.max.flightticketsapp.data.mappers.toUIOffer
import com.max.flightticketsapp.data.model.OffersListUi
import com.max.flightticketsapp.data.model.TicketsListUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketsViewModel @Inject constructor(private val ticketsRepository: TicketsRepository) :
    ViewModel() {
    private val _ticketsUiState: MutableStateFlow<TicketsUiState> =
        MutableStateFlow(TicketsUiState())
    val ticketsUiState: StateFlow<TicketsUiState> = _ticketsUiState.asStateFlow()

    init {
        viewModelScope.launch {
            val tickets = updateTickets()
            _ticketsUiState.update {
                it.copy(
                    tickets = tickets
                )
            }
        }
    }

    private suspend fun updateTickets(): TicketsListUi {
        val offers = ticketsRepository.getTickets().toTicketsUi()
        return offers
    }
}