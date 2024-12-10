package com.max.flightticketsapp.ui.flightsFragment

import com.max.flightticketsapp.data.model.Arrival
import com.max.flightticketsapp.data.model.Departure
import com.max.flightticketsapp.data.model.Offer

data class FlightsUiState (
    // могу ли использовать такие объекты напрямую из модели?
    val departure: Departure? = null,
    val arrival: Arrival? = null,
    val offers: List<Offer>? = null
)