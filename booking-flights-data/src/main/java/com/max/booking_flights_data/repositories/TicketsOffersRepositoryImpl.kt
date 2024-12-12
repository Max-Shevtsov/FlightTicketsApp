package com.max.booking_flights_data.repositories

import com.max.booking_flights_data.api.TicketsOffersApi
import com.max.booking_flights_data.mappers.toTicketsOffers
import com.max.booking_flights_domain.models.TicketsOffers
import com.max.booking_flights_domain.repositories.TicketsOffersRepository
import javax.inject.Inject

class TicketsOffersRepositoryImpl@Inject constructor(
    private val ticketsOfferApi: TicketsOffersApi
): TicketsOffersRepository {
    override suspend fun getTicketsOffer(): List<TicketsOffers> {
        return ticketsOfferApi.getTicketsOffers().toTicketsOffers()
    }
}