package com.max.flightticketsapp.data.model


data class TicketsOffer(

    var id: Int? = null,
    var title: String? = null,
    var timeRange: ArrayList<String> = arrayListOf(),
    var price: Price? = Price()

)
