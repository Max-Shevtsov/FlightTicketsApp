package com.max.flightticketsapp.ui.ticketsOffersFragment

import com.max.flightticketsapp.data.model.TicketsOffer

data class TicketsOffersUiState(
    val ticketsOffers: List<TicketsOffer> = emptyList()
)
