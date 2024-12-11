package com.max.booking_flights_data.di

import dagger.Subcomponent

interface BookingFlightsDataComponent {

    fun getBookingFlightsDependencies(): BookingFlightsDependencies
}

@Subcomponent
internal class BookingFlightsDataComponentImpl: BookingFlightsDataComponent {
    
    override fun getBookingFlightsDependencies(): BookingFlightsDependencies {
        TODO("Not yet implemented")
    }
}