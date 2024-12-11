package com.max.flightticketsapp.di

import com.max.booking_flights_data.di.BookingFlightsDataComponent
import dagger.Component

@Component()
interface AppComponent {
    val bookingFlightsDataComponent: BookingFlightsDataComponent
}