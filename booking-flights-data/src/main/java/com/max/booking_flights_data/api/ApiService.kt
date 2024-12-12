package com.max.booking_flights_data.api

import com.max.booking_flights_data.api.models.OffersListApi
import com.max.booking_flights_data.api.models.TicketsListApi
import com.max.booking_flights_data.api.models.TicketsOffersListApi

import retrofit2.http.GET

interface OffersApi {
    @GET("uc?id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav&export=download")
    suspend fun getOffers(): OffersListApi
}
interface TicketsOffersApi {
    @GET("uc?id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta&export=download")
    suspend fun getTicketsOffers(): TicketsOffersListApi
}
interface TicketsApi {
    @GET("uc?export=download&id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
    suspend fun getTickets(): TicketsListApi
}
