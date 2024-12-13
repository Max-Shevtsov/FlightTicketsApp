package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.DepartureTown
import kotlinx.coroutines.flow.Flow

interface DeparturesTownRepository {
    suspend fun saveDeparturesTown(departuresTown: String)
    suspend fun getDeparturesTown(): Flow<DepartureTown>
}