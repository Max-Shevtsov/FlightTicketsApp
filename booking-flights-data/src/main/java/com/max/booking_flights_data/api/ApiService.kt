/*
package com.max.booking_flights_data.api

import com.max.booking_flights_data.api.models.OffersList
import com.max.booking_flights_domain.models.Tickets
import com.max.booking_flights_domain.models.TicketsOffers
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://drive.usercontent.google.com/u/0/"
interface OffersApi {
    @GET("uc?id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav&export=download")
    suspend fun getOffers(): OffersList
}
interface TicketsOffersApi {
    @GET("uc?id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta&export=download")
    suspend fun getTicketsOffers(): TicketsOffers
}
interface TicketsApi {
    @GET("uc?export=download&id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
    suspend fun getTickets(): Tickets
}

internal object Retrofit {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    val offersApi: OffersApi by lazy {
        retrofit.create(OffersApi::class.java)
    }
    val ticketsOffersApi: TicketsOffersApi by lazy {
        retrofit.create(TicketsOffersApi::class.java)
    }
    val ticketsApi: TicketsApi by lazy {
        retrofit.create(TicketsApi::class.java)
    }
}*/
