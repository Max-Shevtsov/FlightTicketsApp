package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

data class TicketsListApi(
    @SerializedName("tickets") var tickets: ArrayList<TicketApi> = arrayListOf()
)
