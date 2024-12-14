package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.models.TicketDomain
import com.max.booking_flights_domain.models.TicketsListDomain
import com.max.booking_flights_domain.repositories.TicketsRepository

interface TicketsUseCase {
    suspend operator fun invoke(): TicketsListDomain
}

class TicketsUseCaseImpl(
    private val ticketsRepository: TicketsRepository
) : TicketsUseCase {


    override suspend fun invoke(): TicketsListDomain {
        return ticketsRepository.getTickets()
    }
}