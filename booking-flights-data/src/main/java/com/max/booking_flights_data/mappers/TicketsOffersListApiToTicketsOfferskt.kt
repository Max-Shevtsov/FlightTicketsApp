package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.TicketsOffersListApi
import com.max.booking_flights_domain.models.TicketsOffers

internal fun TicketsOffersListApi.toTicketsOffers(): List<TicketsOffers> {
    return ticketOffers.map {
        TicketsOffers(
            id = it.id,
            title = it.title,
            timeRange = it.timeRange,
            price = it.priceApi?.toPrice()
        )
    }
}

