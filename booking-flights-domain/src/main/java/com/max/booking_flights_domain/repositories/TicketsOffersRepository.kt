package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.TicketsOffersListDomain

interface TicketsOffersRepository {
    suspend fun getTicketsOffer(): TicketsOffersListDomain
}