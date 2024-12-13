package com.max.booking_flights_data.di

import com.max.booking_flights_data.api.models.OffersListApi
import com.max.booking_flights_data.api.models.TicketsListApi
import com.max.booking_flights_data.api.models.TicketsOffersListApi
import dagger.Module
import dagger.Provides
import jakarta.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiServicesModule {

    @Provides
    fun providesOffersApi(retrofit: Retrofit): OffersListApi {
        return retrofit.create(OffersListApi::class.java)
    }

    @Provides
    fun providesTicketsOffersApi(retrofit: Retrofit): TicketsOffersListApi {
        return retrofit.create(TicketsOffersListApi::class.java)
    }

    @Provides
    fun providesTicketsApi(retrofit: Retrofit): TicketsListApi {
        return retrofit.create(TicketsListApi::class.java)
    }

    @Provides
    @Singleton

    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private companion object {

        const val BASE_URL = "https://drive.usercontent.google.com/u/0/"
    }
}