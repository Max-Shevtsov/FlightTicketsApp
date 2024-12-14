package com.max.flightticketsapp.data.model



data class OfferUi(

    var id: Int? = null,
    var title: String? = null,
    var town: String? = null,
    var price: PriceUi? = PriceUi()

)

