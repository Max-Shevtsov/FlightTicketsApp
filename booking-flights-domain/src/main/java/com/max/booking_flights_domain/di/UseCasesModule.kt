package com.max.booking_flights_domain.di

import com.max.booking_flights_domain.usecases.FlightToConcertsOfferUseCase
import com.max.booking_flights_domain.usecases.FlightToConcertsOfferUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCasesModule {

    @Binds
    fun bindsFlightToConcertsOfferUseCase(
        useCaseImpl: FlightToConcertsOfferUseCaseImpl,
    ): FlightToConcertsOfferUseCase
}