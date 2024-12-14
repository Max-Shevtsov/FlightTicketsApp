package com.max.flightticketsapp.data.mappers

import com.max.booking_flights_domain.models.OffersListDomain
import com.max.booking_flights_domain.models.PriceDomain
import com.max.flightticketsapp.data.model.OfferUi
import com.max.flightticketsapp.data.model.OffersListUi
import com.max.flightticketsapp.data.model.PriceUi

fun OffersListDomain.toUIOffer(): OffersListUi {
    return OffersListUi(
        offersDomain.map {
            OfferUi(
                id = it.id,
                title = it.title,
                town = it.town,
                price = it.priceDomain?.toPriceUi()
            )
        }
    )
}

fun PriceDomain.toPriceUi(): PriceUi {
    return PriceUi(
        value = value
    )
}
