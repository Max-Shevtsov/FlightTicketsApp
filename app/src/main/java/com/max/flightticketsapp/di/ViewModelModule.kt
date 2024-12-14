package com.max.flightticketsapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.max.flightticketsapp.di.ViewModelFactory
import com.max.flightticketsapp.ui.flightsFragment.FlightsViewModel
import com.max.flightticketsapp.ui.searchFragment.SearchViewModel
import com.max.flightticketsapp.ui.ticketsFragment.TicketsViewModel
import com.max.flightticketsapp.ui.ticketsOffersFragment.TicketsOffersViewModel
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.Binds

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FlightsViewModel::class)
    fun bindFlightsViewModel(vm: FlightsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TicketsOffersViewModel::class)
    fun bindTicketsOffersViewModel(vm: TicketsOffersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TicketsViewModel::class)
    fun bindTicketsViewModel(vm: TicketsViewModel): ViewModel

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}