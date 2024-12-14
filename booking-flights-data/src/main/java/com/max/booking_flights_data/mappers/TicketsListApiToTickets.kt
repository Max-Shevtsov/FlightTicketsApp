package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.api.models.ArrivalApi
import com.max.booking_flights_data.api.models.DepartureApi
import com.max.booking_flights_data.api.models.LuggageApi
import com.max.booking_flights_data.api.models.TicketsListApi
import com.max.booking_flights_domain.models.ArrivalDomain
import com.max.booking_flights_domain.models.DepartureDomain
import com.max.booking_flights_domain.models.LuggageDomain
import com.max.booking_flights_domain.models.TicketDomain
import com.max.booking_flights_domain.models.TicketsListDomain

internal fun TicketsListApi.toTickets(): TicketsListDomain {
    return TicketsListDomain(
        tickets.map {
            TicketDomain(
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
    )

}

fun DepartureApi.toDeparture(): DepartureDomain {
    return DepartureDomain(
        town = town,
        date = date,
        airport = airport
    )
}

fun ArrivalApi.toArrival(): ArrivalDomain {
    return ArrivalDomain(
        town = town,
        date = date,
        airport = airport
    )
}

fun LuggageApi.toLuggage(): LuggageDomain {
    return LuggageDomain(
        hasLuggage = hasLuggage,
        price = priceApi?.toPrice()
    )
}