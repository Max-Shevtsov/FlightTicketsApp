package com.max.flightticketsapp.data.mappers

import com.max.booking_flights_domain.models.ArrivalDomain
import com.max.booking_flights_domain.models.DepartureDomain
import com.max.booking_flights_domain.models.LuggageDomain
import com.max.booking_flights_domain.models.TicketsListDomain
import com.max.flightticketsapp.data.model.ArrivalUi
import com.max.flightticketsapp.data.model.DepartureUi
import com.max.flightticketsapp.data.model.LuggageUi
import com.max.flightticketsapp.data.model.TicketUi
import com.max.flightticketsapp.data.model.TicketsListUi

fun TicketsListDomain.toTicketsUi(): TicketsListUi {
    return TicketsListUi(
        tickets.map {
            TicketUi(
                id = it.id,
                badge = it.badge,
                price = it.price?.toPriceUi(),
                providerName = it.providerName,
                company = it.company,
                departure = it.departure?.toDepartureUi(),
                arrival = it.arrival?.toArrivalUi(),
                hasTransfer = it.hasTransfer,
                luggage = it.luggage?.toLuggageUi()
            )
        }
    )

}

fun DepartureDomain.toDepartureUi(): DepartureUi {
    return DepartureUi(
        town = town,
        date = date,
        airport = airport
    )
}

fun ArrivalDomain.toArrivalUi(): ArrivalUi {
    return ArrivalUi(
        town = town,
        date = date,
        airport = airport
    )
}

fun LuggageDomain.toLuggageUi(): LuggageUi {
    return LuggageUi(
        hasLuggage = hasLuggage,
        price = price?.toPriceUi()
    )
}