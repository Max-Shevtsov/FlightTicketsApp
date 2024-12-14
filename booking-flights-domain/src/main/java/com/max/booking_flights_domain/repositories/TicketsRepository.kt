package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.TicketDomain
import com.max.booking_flights_domain.models.TicketsListDomain

interface TicketsRepository {
    suspend fun getTickets(): TicketsListDomain
}
