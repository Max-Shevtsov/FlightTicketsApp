package com.max.flightticketsapp.ui.flightsFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.max.booking_flights_domain.repositories.DeparturesTownRepository
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import com.max.flightticketsapp.data.mappers.toDeparturesTownUi
import com.max.flightticketsapp.data.mappers.toUIOffer
import com.max.flightticketsapp.data.model.DepartureTownUi
import com.max.flightticketsapp.data.model.OfferUi
import com.max.flightticketsapp.data.model.OffersListUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.prefs.Preferences
import javax.inject.Inject

class FlightsViewModel @Inject constructor(
    private val flightToConcertsOffersRepository: FlightToConcertsOffersRepository,
    private val departuresTownRepository: DeparturesTownRepository
) :
    ViewModel() {
    private val _flightsUiState: MutableStateFlow<FlightsUiState> =
        MutableStateFlow(FlightsUiState())
    val flightsUiState: StateFlow<FlightsUiState> = _flightsUiState.asStateFlow()

    init {
        viewModelScope.launch {
            var departuresTown = DepartureTownUi()
            val offers = updateOffers()
            getDepartureTown().collect{ departuresTown.departuresTown = it.departuresTown}
            _flightsUiState.update {
                it.copy(
                    offersUi = offers,
                    departureTown = departuresTown
                )
            }
        }
    }

    private suspend fun updateOffers(): OffersListUi {

        val offers = flightToConcertsOffersRepository.getFlightToConcertOffer().toUIOffer()

        return offers

    }

    private suspend fun getDepartureTown(): Flow<DepartureTownUi> {
       val departuresTown = departuresTownRepository.getDeparturesTown().map { it.toDeparturesTownUi() }
        Log.e("!!!", "get dep town: $departuresTown")
        return departuresTown
    }

    suspend fun setDepartureTown(town: CharSequence?) {
        departuresTownRepository.saveDeparturesTown(town.toString())
        Log.e("!!!", "save dep town")

    }

}