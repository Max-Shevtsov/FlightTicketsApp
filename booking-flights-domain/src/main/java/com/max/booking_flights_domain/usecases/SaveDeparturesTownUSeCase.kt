package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.repositories.DeparturesTownRepository

interface SaveDeparturesTownUseCase {
    suspend fun saveDepartureTown(town: String)
}

class SaveDeparturesTownUseCaseImpl(
    private val departuresTownRepository: DeparturesTownRepository
) : SaveDeparturesTownUseCase {


    override suspend fun saveDepartureTown(town:String) {
        departuresTownRepository.saveDeparturesTown(town)
    }
}