package com.max.booking_flights_domain.models


data class FlightToConcertOffer(

    var id: Int? = null,
    var title: String? = null,
    var town: String? = null,
    var price: Price? = Price()

)

