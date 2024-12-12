package com.max.booking_flights_data.repositories

import com.max.booking_flights_data.api.TicketsApi
import com.max.booking_flights_data.mappers.toTickets
import com.max.booking_flights_domain.models.Ticket
import com.max.booking_flights_domain.repositories.TicketsRepository
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(
    private val ticketsApi: TicketsApi
) : TicketsRepository {
    override suspend fun getTickets(): List<Ticket> {
        return ticketsApi.getTickets().toTickets()
    }
}