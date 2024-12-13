package com.max.booking_flights_domain.usecases

import com.max.booking_flights_domain.repositories.DeparturesTownRepository


interface GetDeparturesTownUseCase {
    suspend operator fun invoke()
}

class GetDeparturesTownUseCaseImpl(
    private val departuresTownRepository: DeparturesTownRepository
) : GetDeparturesTownUseCase {


    override suspend fun invoke() {
        departuresTownRepository.getDeparturesTown()
    }
}