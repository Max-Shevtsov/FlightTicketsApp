package com.max.booking_flights_data.api.models


import com.google.gson.annotations.SerializedName


internal data class OffersList (

    @SerializedName("offers" ) var offers : ArrayList<Offer> = arrayListOf()

)

internal data class Offer (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("title" ) var title : String? = null,
    @SerializedName("town"  ) var town  : String? = null,
    @SerializedName("price" ) var price : Price?  = Price()

)

