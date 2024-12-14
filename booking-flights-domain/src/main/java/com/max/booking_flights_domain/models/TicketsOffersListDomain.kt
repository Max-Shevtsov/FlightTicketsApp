package com.max.booking_flights_domain.models

data class TicketsOffersListDomain (
    val ticketsOffers: List<TicketsOffersDomain> = emptyList()
)