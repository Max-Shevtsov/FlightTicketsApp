package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.OffersList
import com.max.booking_flights_data.api.models.PriceApi
import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.models.Price

internal fun OffersList.toFlightToConcertOffer(): List<FlightToConcertOffer> {
    return offers.map {
        FlightToConcertOffer(
            id = it.id,
            title = it.title,
            town = it.town,
            price = it.priceApi?.toPrice(),
        )
    }
}

internal fun PriceApi.toPrice(): Price {
    return Price()
}