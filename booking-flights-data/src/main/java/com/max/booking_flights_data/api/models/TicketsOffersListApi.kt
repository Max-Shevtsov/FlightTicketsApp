package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

internal data class TicketsOffersListApi(
    @SerializedName("ticketsOffers") var ticketOffers: ArrayList<TicketsOfferApi> = arrayListOf()
)
