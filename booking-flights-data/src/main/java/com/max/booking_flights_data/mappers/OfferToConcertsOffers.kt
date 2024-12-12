package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.OffersListApi
import com.max.booking_flights_data.api.models.PriceApi
import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.models.Price

internal fun OffersListApi.toFlightToConcertOffer(): List<FlightToConcertOffer> {
    return offersApi.map {
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