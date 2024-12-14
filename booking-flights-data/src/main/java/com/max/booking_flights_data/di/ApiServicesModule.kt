package com.max.booking_flights_data.di

import com.max.booking_flights_data.api.OffersApiInterface
import com.max.booking_flights_data.api.TicketsApiInterface
import com.max.booking_flights_data.api.TicketsOffersApiInterface
import com.max.booking_flights_data.api.models.OffersListApi
import com.max.booking_flights_data.api.models.TicketsListApi
import com.max.booking_flights_data.api.models.TicketsOffersListApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiServicesModule {

    @Provides
    fun providesOffersApi(retrofit: Retrofit): OffersApiInterface {
        return retrofit.create(OffersApiInterface::class.java)
    }

    @Provides
    fun providesTicketsOffersApi(retrofit: Retrofit): TicketsOffersApiInterface {
        return retrofit.create(TicketsOffersApiInterface::class.java)
    }

    @Provides
    fun providesTicketsApi(retrofit: Retrofit): TicketsApiInterface {
        return retrofit.create(TicketsApiInterface::class.java)
    }
    @Singleton
    @Provides
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