package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.db.DepartureTownDb
import com.max.booking_flights_domain.models.DepartureTownDomain

fun DepartureTownDb.toDeparturesTown(): DepartureTownDomain {
    return DepartureTownDomain(
        departuresTown = departuresTown
    )
}