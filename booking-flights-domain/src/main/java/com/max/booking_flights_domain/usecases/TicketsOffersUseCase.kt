package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.models.TicketsOffersDomain
import com.max.booking_flights_domain.models.TicketsOffersListDomain
import com.max.booking_flights_domain.repositories.TicketsOffersRepository

interface TicketsOffersUseCase {
    suspend operator fun invoke(): TicketsOffersListDomain
}

class TicketsOffersUseCaseImpl(
    private val ticketsOffersRepository: TicketsOffersRepository
): TicketsOffersUseCase {


    override suspend fun invoke(): TicketsOffersListDomain {
        return ticketsOffersRepository.getTicketsOffer()
    }
}