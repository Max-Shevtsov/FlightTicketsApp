package com.max.flightticketsapp.data.model


data class TicketsOfferUi(

    var id: Int? = null,
    var title: String? = null,
    var timeRange: List<String> = emptyList(),
    var price: PriceUi? = PriceUi()

)
