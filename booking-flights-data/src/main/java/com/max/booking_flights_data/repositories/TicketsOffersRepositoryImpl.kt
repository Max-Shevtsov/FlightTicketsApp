package com.max.booking_flights_data.repositories

import android.util.Log
import com.max.booking_flights_data.api.TicketsOffersApiInterface
import com.max.booking_flights_data.mappers.toTicketsOffers
import com.max.booking_flights_domain.models.TicketsOffersDomain
import com.max.booking_flights_domain.models.TicketsOffersListDomain
import com.max.booking_flights_domain.repositories.TicketsOffersRepository
import javax.inject.Inject

class TicketsOffersRepositoryImpl@Inject constructor(
    private val ticketsOfferApi: TicketsOffersApiInterface
): TicketsOffersRepository {
    override suspend fun getTicketsOffer(): TicketsOffersListDomain {
        val ticketOffers = ticketsOfferApi.getTicketsOffers()
        Log.e("!!!", "ticketsOffers: $ticketOffers")
        return ticketOffers.toTicketsOffers()
    }
}