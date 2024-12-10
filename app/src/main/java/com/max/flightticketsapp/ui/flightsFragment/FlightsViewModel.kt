package com.max.flightticketsapp.ui.flightsFragment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FlightsViewModel(/*private val offersRepository: OffersRepository*/) : ViewModel() {
    private val _flightsUiState: MutableStateFlow<FlightsUiState> =
        MutableStateFlow(FlightsUiState())
    val flightsUiState: StateFlow<FlightsUiState> = _flightsUiState.asStateFlow()

    /*init {
        viewModelScope.launch {
            val offers = updateOffers()
            _flightsUiState.update {
                it.copy(
                    offers = offers
                )
            }
        }
    }

    private suspend fun updateOffers(): ArrayList<FlightToConcertOffer> {
        return offersRepository.getOffers().offers
    }

    companion object {
        val Factory: ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    if (modelClass.isAssignableFrom(FlightsViewModel::class.java)) {
                        val application = checkNotNull(extras[APPLICATION_KEY])
                        val applicationScope = CoroutineScope(SupervisorJob())
                        val offersRepository = OffersRepository(

                            networkDataSource = com.max.booking_flights_data.api.Retrofit.offersApi
                        )

                        return FlightsViewModel(
                            offersRepository = offersRepository,

                            ) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel")
                }
            }
    }*/
}