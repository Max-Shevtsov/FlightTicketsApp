package com.max.booking_flights_domain.models


data class TicketDomain(

    var id: Int? = null,
    var badge: String? = null,
    var price: PriceDomain? = PriceDomain(),
    var providerName: String? = null,
    var company: String? = null,
    var departure: DepartureDomain? = DepartureDomain(),
    var arrival: ArrivalDomain? = ArrivalDomain(),
    var hasTransfer: Boolean? = null,
    var hasVisaTransfer: Boolean? = null,
    var luggage: LuggageDomain? = LuggageDomain(),
    var handLuggage: HandLuggageDomain? = HandLuggageDomain(),
    var isReturnable: Boolean? = null,
    var isExchangable: Boolean? = null

)