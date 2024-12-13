package com.max.flightticketsapp.ui.flightsFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import com.max.booking_flights_domain.usecases.FlightToConcertsOfferUseCase
import com.max.flightticketsapp.data.mappers.toUIOffer
import com.max.flightticketsapp.data.model.Offer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlightsViewModel @Inject constructor(private val flightToConcertsOffersRepository: FlightToConcertsOffersRepository) :
    ViewModel() {
    private val _flightsUiState: MutableStateFlow<FlightsUiState> =
        MutableStateFlow(FlightsUiState())
    val flightsUiState: StateFlow<FlightsUiState> = _flightsUiState.asStateFlow()

    init {
        viewModelScope.launch {
            val offers = updateOffers()
            _flightsUiState.update {
                it.copy(
                    offers = offers
                )
            }
        }
    }

    private suspend fun updateOffers(): List<Offer> {
        return flightToConcertsOffersRepository.getFlightToConcertOffer().toUIOffer()
    }


}