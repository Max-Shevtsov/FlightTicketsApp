package com.max.flightticketsapp.data.model


data class Tickets(

    var id: Int? = null,
    var badge: String? = null,
    var price: Price? = Price(),
    var providerName: String? = null,
    var company: String? = null,
    var departure: Departure? = Departure(),
    var arrival: Arrival? = Arrival(),
    var hasTransfer: Boolean? = null,
    var hasVisaTransfer: Boolean? = null,
    var luggage: Luggage? = Luggage(),
    var handLuggage: HandLuggage? = HandLuggage(),
    var isReturnable: Boolean? = null,
    var isExchangable: Boolean? = null

)