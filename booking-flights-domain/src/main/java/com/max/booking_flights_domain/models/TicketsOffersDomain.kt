package com.max.booking_flights_domain.models


data class TicketsOffersDomain(

    var id: Int? = null,
    var title: String? = null,
    var timeRange: ArrayList<String> = arrayListOf(),
    var price: PriceDomain? = PriceDomain()

)