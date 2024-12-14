package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.OffersListDomain

interface FlightToConcertsOffersRepository {
    suspend fun getFlightToConcertOffer(): OffersListDomain
}