package com.max.flightticketsapp.ui.flightsFragment

import com.max.flightticketsapp.data.model.ArrivalUi
import com.max.flightticketsapp.data.model.DepartureUi
import com.max.flightticketsapp.data.model.OffersListUi

data class FlightsUiState (
    val departureUi: DepartureUi? = null,
    val arrivalUi: ArrivalUi? = null,
    val offersUi: OffersListUi =OffersListUi(emptyList())
)