package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName


data class ArrivalApi (

    @SerializedName("town"    ) var town    : String? = null,
    @SerializedName("date"    ) var date    : String? = null,
    @SerializedName("airport" ) var airport : String? = null

)