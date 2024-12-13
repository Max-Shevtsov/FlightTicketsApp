package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

data class TicketsOfferApi(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("time_range") var timeRange: ArrayList<String> = arrayListOf(),
    @SerializedName("priceApi") var priceApi: PriceApi? = PriceApi()

)