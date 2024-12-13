package com.max.booking_flights_data.api.models

import com.google.gson.annotations.SerializedName

data class TicketApi(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("badge") var badge: String? = null,
    @SerializedName("price") var price: PriceApi? = PriceApi(),
    @SerializedName("provider_name") var providerName: String? = null,
    @SerializedName("company") var company: String? = null,
    @SerializedName("departure") var departureApi: DepartureApi? = DepartureApi(),
    @SerializedName("arrival") var arrivalApi: ArrivalApi? = ArrivalApi(),
    @SerializedName("has_transfer") var hasTransfer: Boolean? = null,
    @SerializedName("has_visa_transfer") var hasVisaTransfer: Boolean? = null,
    @SerializedName("luggage") var luggageApi: LuggageApi? = LuggageApi(),
    @SerializedName("hand_luggage") var handLuggageApi: HandLuggageApi? = HandLuggageApi(),
    @SerializedName("is_returnable") var isReturnable: Boolean? = null,
    @SerializedName("is_exchangable") var isExchangable: Boolean? = null

)