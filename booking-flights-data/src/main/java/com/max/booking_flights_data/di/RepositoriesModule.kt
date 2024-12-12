package com.max.booking_flights_data.di

import com.max.booking_flights_data.repositories.FlightToConcertsOffersRepositoryImpl
import com.max.booking_flights_data.repositories.SaveDeparturesTownRepositoryImpl
import com.max.booking_flights_data.repositories.TicketsOffersRepositoryImpl
import com.max.booking_flights_data.repositories.TicketsRepositoryImpl
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import com.max.booking_flights_domain.repositories.SaveDeparturesTownRepository
import com.max.booking_flights_domain.repositories.TicketsOffersRepository
import com.max.booking_flights_domain.repositories.TicketsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindsFlightToConcertsOffersRepository(
        repositoryImpl: FlightToConcertsOffersRepositoryImpl
    ): FlightToConcertsOffersRepository

    @Binds
    fun bindsSaveDeparturesTownRepository(
        repositoryImpl: SaveDeparturesTownRepositoryImpl
    ): SaveDeparturesTownRepository

    @Binds
    fun bindsTicketsOffersRepository(
        repositoryImpl: TicketsOffersRepositoryImpl
    ): TicketsOffersRepository

    @Binds
    fun bindsTicketsRepository(
        repositoryImpl: TicketsRepositoryImpl
    ): TicketsRepository
}