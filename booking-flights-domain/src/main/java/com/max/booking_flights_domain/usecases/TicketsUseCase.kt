package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.models.Ticket
import com.max.booking_flights_domain.models.TicketsOffers
import com.max.booking_flights_domain.repositories.TicketsOffersRepository
import com.max.booking_flights_domain.repositories.TicketsRepository

interface TicketsUseCase {
    suspend operator fun invoke(): List<Ticket>
}

class TicketsUseCaseImpl(
    private val ticketsRepository: TicketsRepository
) : TicketsUseCase {


    override suspend fun invoke(): List<Ticket> {
        return ticketsRepository.getTickets()
    }
}