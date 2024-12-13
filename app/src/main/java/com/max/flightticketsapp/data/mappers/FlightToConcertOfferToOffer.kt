package com.max.flightticketsapp.data.mappers

import com.max.booking_flights_data.api.models.PriceApi
import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.models.Price
import com.max.flightticketsapp.data.model.Offer

fun List<FlightToConcertOffer>.toUIOffer(): List<Offer> {
    return listOf(FlightToConcertOffer()).map {
        Offer(
            id = it.id,
            title = it.title,
            town = it.town
        )
    }
}


