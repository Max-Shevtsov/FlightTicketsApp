package com.max.booking_flights_data.mappers

import com.max.booking_flights_data.db.DepartureTownDb
import com.max.booking_flights_domain.models.DepartureTown

fun DepartureTownDb.toDeparturesTown(): DepartureTown {
    return DepartureTown(
        departuresTown = departuresTown
    )
}