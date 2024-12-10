package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

internal data class Price (

    @SerializedName("value" ) var value : Int? = null

)