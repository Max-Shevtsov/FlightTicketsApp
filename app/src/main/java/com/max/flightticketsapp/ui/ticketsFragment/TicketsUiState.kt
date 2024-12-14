package com.max.flightticketsapp.ui.ticketsFragment

import com.max.flightticketsapp.data.model.TicketUi
import com.max.flightticketsapp.data.model.TicketsListUi

data class TicketsUiState(
    val tickets: TicketsListUi = TicketsListUi(emptyList())
)
