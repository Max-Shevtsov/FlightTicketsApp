package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

internal data class TicketsOffersList(
    @SerializedName("ticketsOffers") var ticketOffers: ArrayList<TicketsOffer> = arrayListOf()
)


internal data class TicketsOffer(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("time_range") var timeRange: ArrayList<String> = arrayListOf(),
    @SerializedName("price") var price: Price? = Price()

)