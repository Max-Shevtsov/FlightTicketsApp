package com.max.flightticketsapp.di

import androidx.fragment.app.Fragment
import com.max.booking_flights_data.di.ApiServicesModule
import com.max.booking_flights_data.di.BookingFlightsDataComponent
import com.max.booking_flights_data.di.DbModule
import com.max.booking_flights_data.di.RepositoriesModule
import com.max.booking_flights_domain.di.BookingFlightsDomainComponent
import com.max.booking_flights_domain.di.UseCasesModule
import com.max.flightticketsapp.App
import com.max.flightticketsapp.MainActivity
import com.max.flightticketsapp.ui.flightsFragment.FlightsFragment
import com.max.flightticketsapp.ui.searchFragment.SearchFragment
import com.max.flightticketsapp.ui.ticketsFragment.TicketsFragment
import com.max.flightticketsapp.ui.ticketsOffersFragment.TicketsOffersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiServicesModule::class, DbModule::class, ViewModelModule::class, RepositoriesModule::class, UseCasesModule::class])
interface AppComponent {
//    fun createBookingFlightsDataComponent(): BookingFlightsDataComponent
//    fun createBookingFlightsDomainComponent(): BookingFlightsDomainComponent

    fun inject(app: App)
    fun inject(target: FlightsFragment)
    fun inject(target: TicketsOffersFragment)
    fun inject(target: TicketsFragment)
//    fun Fragment.getAppComponent(): AppComponent =
//        (requireContext() as App).appComponent

}