package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

data class OffersListApi (

    @SerializedName("offers" ) var offersApi : ArrayList<OfferApi> = arrayListOf()

)