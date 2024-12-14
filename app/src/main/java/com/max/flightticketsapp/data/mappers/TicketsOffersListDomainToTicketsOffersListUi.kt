package com.max.flightticketsapp.data.mappers

import com.max.booking_flights_domain.models.TicketsOffersListDomain
import com.max.flightticketsapp.data.model.TicketsOfferListUi
import com.max.flightticketsapp.data.model.TicketsOfferUi

internal fun TicketsOffersListDomain.toTicketsOffersListUi(): TicketsOfferListUi {
    return TicketsOfferListUi(
        ticketsOffers.map{
            TicketsOfferUi(
            id = it.id,
            title = it.title,
            timeRange = it.timeRange,
            price = it.price?.toPriceUi()
            )
        }

    )
}

