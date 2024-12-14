package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.models.OfferDomain
import com.max.booking_flights_domain.models.OffersListDomain
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository

interface FlightToConcertsOfferUseCase {

    suspend operator fun invoke(): OffersListDomain
}

class FlightToConcertsOfferUseCaseImpl(
    private val flightToConcertsOffersRepository: FlightToConcertsOffersRepository
): FlightToConcertsOfferUseCase {


    override suspend fun invoke(): OffersListDomain{
        return flightToConcertsOffersRepository.getFlightToConcertOffer()
    }
}