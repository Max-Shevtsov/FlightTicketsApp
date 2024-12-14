package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.OffersListApi
import com.max.booking_flights_data.api.models.PriceApi
import com.max.booking_flights_domain.models.OfferDomain
import com.max.booking_flights_domain.models.OffersListDomain
import com.max.booking_flights_domain.models.PriceDomain

internal fun OffersListApi.toFlightToConcertOffer(): OffersListDomain {
    return OffersListDomain(
        offersApi.map {
            OfferDomain(
                id = it.id,
                title = it.title,
                town = it.town,
                priceDomain = it.priceApi?.toPrice(),
            )
        }
    )

}

internal fun PriceApi.toPrice(): PriceDomain {
    return PriceDomain(
        value = value
    )
}