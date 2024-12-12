package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.FlightToConcertOffer

interface FlightToConcertsOffersRepository {
    suspend fun getFlightToConcertOffer(): List<FlightToConcertOffer>
}