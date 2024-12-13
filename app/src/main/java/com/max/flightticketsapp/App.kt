package com.max.flightticketsapp

import android.app.Application
import com.max.booking_flights_data.di.BookingFlightsDataComponent
import com.max.booking_flights_domain.di.BookingFlightsDomainComponent
import com.max.flightticketsapp.di.AppComponent
import com.max.flightticketsapp.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
//        getDataComponent(appComponent)
//        getDomainComponent(appComponent)
    }

//    fun getDataComponent(appComponent: AppComponent): BookingFlightsDataComponent {
//        return appComponent.createBookingFlightsDataComponent()
//    }
//
//    fun getDomainComponent(appComponent: AppComponent): BookingFlightsDomainComponent {
//        return appComponent.createBookingFlightsDomainComponent()
//    }
}