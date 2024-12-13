package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.ArrivalApi
import com.max.booking_flights_data.api.models.DepartureApi
import com.max.booking_flights_data.api.models.LuggageApi
import com.max.booking_flights_data.api.models.PriceApi
import com.max.booking_flights_data.api.models.TicketsListApi
import com.max.booking_flights_domain.models.Arrival
import com.max.booking_flights_domain.models.Departure
import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.models.Luggage
import com.max.booking_flights_domain.models.Price
import com.max.booking_flights_domain.models.Ticket

internal fun TicketsListApi.toTickets(): List<Ticket> {
    return tickets.map {
        Ticket(
            id = it.id,
            badge = it.badge,
            price = it.price?.toPrice(),
            providerName = it.providerName,
            company = it.company,
            departure = it.departureApi?.toDeparture(),
            arrival = it.arrivalApi?.toArrival(),
            hasTransfer = it.hasTransfer,
            luggage = it.luggageApi?.toLuggage()
        )
    }
}

fun DepartureApi.toDeparture(): Departure {
    return Departure(
        town = town,
        date = date,
        airport = airport
    )
}

fun ArrivalApi.toArrival(): Arrival {
    return Arrival(
        town = town,
        date = date,
        airport = airport
    )
}

fun LuggageApi.toLuggage(): Luggage {
    return Luggage(
        hasLuggage = hasLuggage,
        price = priceApi?.toPrice()
    )
}