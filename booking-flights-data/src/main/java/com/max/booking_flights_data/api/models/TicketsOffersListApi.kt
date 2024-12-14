package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

data class TicketsOffersListApi(
    @SerializedName("tickets_offers") var ticketOffers: ArrayList<TicketsOfferApi> = arrayListOf()
)
