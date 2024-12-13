package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.models.TicketsOffers
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import com.max.booking_flights_domain.repositories.TicketsOffersRepository

interface TicketsOffersUseCase {
    suspend operator fun invoke(): List<TicketsOffers>
}

class TicketsOffersUseCaseImpl(
    private val ticketsOffersRepository: TicketsOffersRepository
): TicketsOffersUseCase {


    override suspend fun invoke(): List<TicketsOffers> {
        return ticketsOffersRepository.getTicketsOffer()
    }
}