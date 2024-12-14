package com.max.booking_flights_data.repositories

import com.max.booking_flights_data.api.TicketsApiInterface
import com.max.booking_flights_data.mappers.toTickets
import com.max.booking_flights_domain.models.TicketDomain
import com.max.booking_flights_domain.models.TicketsListDomain
import com.max.booking_flights_domain.repositories.TicketsRepository
import javax.inject.Inject

class TicketsRepositoryImpl @Inject constructor(
    private val ticketsApiInterface: TicketsApiInterface
) : TicketsRepository {
    override suspend fun getTickets(): TicketsListDomain {
        return ticketsApiInterface.getTickets().toTickets()
    }
}