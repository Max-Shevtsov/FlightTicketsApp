package com.max.flightticketsapp.ui.flightsFragment

import com.max.flightticketsapp.data.model.ArrivalUi
import com.max.flightticketsapp.data.model.DepartureTownUi
import com.max.flightticketsapp.data.model.DepartureUi
import com.max.flightticketsapp.data.model.OffersListUi

data class FlightsUiState (
    val departureTown: DepartureTownUi = DepartureTownUi(),
    val offersUi: OffersListUi =OffersListUi(emptyList())
)