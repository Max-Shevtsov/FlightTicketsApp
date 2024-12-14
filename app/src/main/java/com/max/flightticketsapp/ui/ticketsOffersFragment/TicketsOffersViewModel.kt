package com.max.flightticketsapp.ui.ticketsOffersFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.booking_flights_domain.repositories.TicketsOffersRepository
import com.max.booking_flights_domain.usecases.TicketsOffersUseCase
import com.max.flightticketsapp.data.mappers.toTicketsOffersListUi
import com.max.flightticketsapp.data.mappers.toTicketsUi
import com.max.flightticketsapp.data.model.TicketsListUi
import com.max.flightticketsapp.data.model.TicketsOfferListUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class TicketsOffersViewModel @Inject constructor(private val ticketsOffersRepository: TicketsOffersRepository) :
    ViewModel() {
    private val _ticketsOffersUiState: MutableStateFlow<TicketsOffersUiState> =
        MutableStateFlow(TicketsOffersUiState())
    val ticketsOffersUiState: StateFlow<TicketsOffersUiState> = _ticketsOffersUiState.asStateFlow()

    init {
        viewModelScope.launch {
            val ticketsOffers = updateTicketOffers()
            _ticketsOffersUiState.update {
                it.copy(
                    ticketsOffers = ticketsOffers
                )
            }
        }
    }

    private suspend fun updateTicketOffers(): TicketsOfferListUi {
        val ticketsOffers = ticketsOffersRepository.getTicketsOffer().toTicketsOffersListUi()
        Log.e("!!!", "ticketsOffersUi: $ticketsOffers")

        return ticketsOffers
    }
}