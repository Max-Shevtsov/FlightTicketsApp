package com.max.flightticketsapp.ui.ticketsFragment

import com.max.flightticketsapp.data.model.Ticket

data class TicketsUiState(
    val tickets: List<Ticket> = emptyList()
)
