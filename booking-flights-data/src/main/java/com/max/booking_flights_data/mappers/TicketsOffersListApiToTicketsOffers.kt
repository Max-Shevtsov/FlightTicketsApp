package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.TicketsOffersListApi
import com.max.booking_flights_domain.models.TicketsOffersDomain
import com.max.booking_flights_domain.models.TicketsOffersListDomain

internal fun TicketsOffersListApi.toTicketsOffers(): TicketsOffersListDomain {
    return TicketsOffersListDomain(
        ticketOffers.map {
            TicketsOffersDomain(
                id = it.id,
                title = it.title,
                timeRange = it.timeRange,
                price = it.priceApi?.toPrice()
            )
        }
    )

}

