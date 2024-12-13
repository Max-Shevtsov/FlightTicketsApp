package com.max.booking_flights_domain.di

import com.max.booking_flights_domain.usecases.FlightToConcertsOfferUseCase
import com.max.booking_flights_domain.usecases.FlightToConcertsOfferUseCaseImpl
import com.max.booking_flights_domain.usecases.SaveDeparturesTownUseCase
import com.max.booking_flights_domain.usecases.SaveDeparturesTownUseCaseImpl
import com.max.booking_flights_domain.usecases.TicketsOffersUseCase
import com.max.booking_flights_domain.usecases.TicketsOffersUseCaseImpl
import com.max.booking_flights_domain.usecases.TicketsUseCase
import com.max.booking_flights_domain.usecases.TicketsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCasesModule {

    @Binds
    fun bindsFlightToConcertsOfferUseCase(
        useCaseImpl: FlightToConcertsOfferUseCaseImpl,
    ): FlightToConcertsOfferUseCase

    @Binds
    fun bindsTicketsOffersUseCase(
        useCaseImpl: TicketsOffersUseCaseImpl,
    ): TicketsOffersUseCase

    @Binds
    fun bindsTicketsUseCase(
        useCaseImpl: TicketsUseCaseImpl,
    ): TicketsUseCase

    @Binds
    fun bindsSaveDeparturesTownUseCase(
        useCaseImpl: SaveDeparturesTownUseCaseImpl,
    ): SaveDeparturesTownUseCase
}