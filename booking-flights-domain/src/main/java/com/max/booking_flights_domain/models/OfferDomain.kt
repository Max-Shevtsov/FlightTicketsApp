package com.max.booking_flights_domain.models


data class OfferDomain(

    var id: Int? = null,
    var title: String? = null,
    var town: String? = null,
    var priceDomain: PriceDomain? = PriceDomain()

)

