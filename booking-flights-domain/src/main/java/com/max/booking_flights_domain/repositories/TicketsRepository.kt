package com.max.booking_flights_domain.repositories

import com.max.booking_flights_domain.models.Ticket

interface TicketsRepository {
    suspend fun getTickets(): List<Ticket>
}
