package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

internal data class LuggageApi (

    @SerializedName("has_luggage" ) var hasLuggage : Boolean? = null,
    @SerializedName("price"       ) var priceApi      : PriceApi?   = PriceApi()

)