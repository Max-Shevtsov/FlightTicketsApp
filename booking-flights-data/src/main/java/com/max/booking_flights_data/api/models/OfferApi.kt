package com.max.booking_flights_data.api.models


import com.google.gson.annotations.SerializedName

data class OfferApi (

    @SerializedName("id"    ) var id    : Int?    = null,
    @SerializedName("title" ) var title : String? = null,
    @SerializedName("town"  ) var town  : String? = null,
    @SerializedName("price" ) var priceApi : PriceApi?  = PriceApi()

)

