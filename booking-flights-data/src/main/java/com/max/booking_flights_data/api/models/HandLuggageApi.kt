package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName


internal data class HandLuggageApi (

    @SerializedName("has_hand_luggage" ) var hasHandLuggage : Boolean? = null,
    @SerializedName("size"             ) var size           : String?  = null

)