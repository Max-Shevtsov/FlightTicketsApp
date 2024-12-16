package com.max.flightticketsapp.data.mappers

import com.max.booking_flights_data.db.DepartureTownDb
import com.max.booking_flights_domain.models.DepartureTownDomain
import com.max.flightticketsapp.data.model.DepartureTownUi

fun DepartureTownDomain.toDeparturesTownUi(): DepartureTownUi {
    return DepartureTownUi(
        departuresTown = departuresTown
    )
}