package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.TicketsOffers

interface TicketsOffersRepository {
    suspend fun getTicketsOffer(): List<TicketsOffers>
}