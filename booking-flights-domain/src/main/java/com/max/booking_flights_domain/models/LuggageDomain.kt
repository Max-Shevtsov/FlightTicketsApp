package com.max.booking_flights_domain.models


data class LuggageDomain(

    var hasLuggage: Boolean? = null,
    var price: PriceDomain? = PriceDomain()

)