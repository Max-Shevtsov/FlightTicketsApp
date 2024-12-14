package com.max.flightticketsapp.data.model


data class TicketUi(

    var id: Int? = null,
    var badge: String? = null,
    var price: PriceUi? = PriceUi(),
    var providerName: String? = null,
    var company: String? = null,
    var departure: DepartureUi? = DepartureUi(),
    var arrival: ArrivalUi? = ArrivalUi(),
    var hasTransfer: Boolean? = null,
    var hasVisaTransfer: Boolean? = null,
    var luggage: LuggageUi? = LuggageUi(),
    var handLuggage: HandLuggageUi? = HandLuggageUi(),
    var isReturnable: Boolean? = null,
    var isExchangable: Boolean? = null

)