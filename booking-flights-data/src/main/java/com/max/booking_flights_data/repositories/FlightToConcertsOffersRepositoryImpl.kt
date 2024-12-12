package com.max.booking_flights_data.repositories

import com.max.booking_flights_data.api.OffersApi
import com.max.booking_flights_data.mappers.toFlightToConcertOffer
import com.max.booking_flights_domain.models.FlightToConcertOffer
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import javax.inject.Inject

class FlightToConcertsOffersRepositoryImpl @Inject constructor(
    private val offersApi: OffersApi,
) : FlightToConcertsOffersRepository {

    override suspend fun getFlightToConcertOffer(): List<FlightToConcertOffer> {
        return offersApi.getOffers().toFlightToConcertOffer()
    }
}