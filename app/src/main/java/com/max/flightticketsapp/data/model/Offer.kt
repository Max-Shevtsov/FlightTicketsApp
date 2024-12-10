package com.max.flightticketsapp.data.model



data class Offer(

    var id: Int? = null,
    var title: String? = null,
    var town: String? = null,
    var price: Price? = Price()

)

