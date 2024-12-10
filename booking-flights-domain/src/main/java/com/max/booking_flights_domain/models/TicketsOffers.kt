package com.max.booking_flights_domain.models


data class TicketsOffers(

    var id: Int? = null,
    var title: String? = null,
    var timeRange: ArrayList<String> = arrayListOf(),
    var price: Price? = Price()

)