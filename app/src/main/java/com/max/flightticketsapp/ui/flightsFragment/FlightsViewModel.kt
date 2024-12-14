package com.max.flightticketsapp.ui.flightsFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import com.max.flightticketsapp.data.mappers.toUIOffer
import com.max.flightticketsapp.data.model.OfferUi
import com.max.flightticketsapp.data.model.OffersListUi
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
                    offersUi = offers
                )
            }
        }
    }

    private suspend fun updateOffers(): OffersListUi {
        val offers = flightToConcertsOffersRepository.getFlightToConcertOffer().toUIOffer()
        Log.e("!!!", "$offers")
        Log.e("!!!", "${offers.offersUi.firstOrNull()?.price?.value}")

        return offers

    }


}