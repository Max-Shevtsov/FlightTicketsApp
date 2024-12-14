package com.max.flightticketsapp.ui.ticketsOffersFragment

import com.max.flightticketsapp.data.model.TicketsOfferListUi

data class TicketsOffersUiState(
    val ticketsOffers: TicketsOfferListUi = TicketsOfferListUi(emptyList())
)
