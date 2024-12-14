package com.max.booking_flights_data.repositories

import android.util.Log
import com.max.booking_flights_data.api.OffersApiInterface
import com.max.booking_flights_data.mappers.toFlightToConcertOffer
import com.max.booking_flights_domain.models.OfferDomain
import com.max.booking_flights_domain.models.OffersListDomain
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import javax.inject.Inject

class FlightToConcertsOffersRepositoryImpl @Inject constructor(
    private val offersApiInterface: OffersApiInterface,
) : FlightToConcertsOffersRepository {

    override suspend fun getFlightToConcertOffer(): OffersListDomain {
       val offersListApi = offersApiInterface.getOffers()
        Log.e("!!!", "OffersListApi$offersListApi")
        Log.e("!!!", "priceApi:${offersListApi.offersApi.firstOrNull()?.priceApi?.value}")
        return offersListApi.toFlightToConcertOffer()
    }
}