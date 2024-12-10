package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

internal data class Luggage (

    @SerializedName("has_luggage" ) var hasLuggage : Boolean? = null,
    @SerializedName("price"       ) var price      : Price?   = Price()

)