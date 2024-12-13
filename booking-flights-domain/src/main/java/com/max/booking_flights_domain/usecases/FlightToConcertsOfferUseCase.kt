package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository

interface FlightToConcertsOfferUseCase {

    suspend operator fun invoke(): List<FlightToConcertOffer>
}

class FlightToConcertsOfferUseCaseImpl(
    private val flightToConcertsOffersRepository: FlightToConcertsOffersRepository
): FlightToConcertsOfferUseCase {


    override suspend fun invoke(): List<FlightToConcertOffer> {
        return flightToConcertsOffersRepository.getFlightToConcertOffer()
    }
}