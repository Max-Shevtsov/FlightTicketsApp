package com.max.booking_flights_data.di

import com.max.booking_flights_data.repositories.FlightToConcertsOffersRepositoryImpl
import com.max.booking_flights_domain.repositories.FlightToConcertsOffersRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindsFlightToConcertsOffersRepository(
        repositoryImpl: FlightToConcertsOffersRepositoryImpl
    ): FlightToConcertsOffersRepository
}