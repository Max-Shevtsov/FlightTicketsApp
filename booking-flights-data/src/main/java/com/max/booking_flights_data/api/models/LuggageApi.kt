package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

data class LuggageApi (

    @SerializedName("has_luggage" ) var hasLuggage : Boolean? = null,
    @SerializedName("priceDomain"       ) var priceApi      : PriceApi?   = PriceApi()

)