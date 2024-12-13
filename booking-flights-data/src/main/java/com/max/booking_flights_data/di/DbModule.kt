package com.max.booking_flights_data.di

import android.content.Context
import com.max.booking_flights_data.repositories.DeparturesTownRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDataStoreRepository(context: Context) = DeparturesTownRepositoryImpl(context)
}
