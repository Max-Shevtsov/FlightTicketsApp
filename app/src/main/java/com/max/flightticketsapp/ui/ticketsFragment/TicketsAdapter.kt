package com.max.flightticketsapp.ui.ticketsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.data.model.TicketUi
import com.max.flightticketsapp.databinding.ItemTicketsBinding
import kotlinx.datetime.DateTimePeriod
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

class TicketsAdapter() :
    ListAdapter<TicketUi, TicketsAdapter.ViewHolder>(DIFFUTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticket = getItem(position)
        holder.bind(ticket)

    }

    class ViewHolder(
        private val binding: ItemTicketsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ticket: TicketUi) {
            with(binding) {
                binding.price.text = "${ticket.price?.value} ₽"
                binding.arrAirport.text = ticket.arrival?.airport
                binding.depAirport.text = ticket.departure?.airport

                if (ticket.hasTransfer == false) {
                    binding.withoutTransferText.text = " Без пересадок"
                    binding.slash.isVisible = true
                } else {
                    binding.slash.isVisible = false
                }

                if (ticket.badge != null) {
                    binding.badge.text = ticket.badge
                    binding.badge.isVisible = true
                } else {
                    binding.badge.isVisible = false
                }

                val arrivalDate = ticket.arrival?.date?.let { LocalDateTime.parse(it) }
                val departureDate = ticket.departure?.date?.let { LocalDateTime.parse(it) }
                val flightTime = departureDate?.toInstant(
                    TimeZone.UTC
                )?.let {
                    arrivalDate?.toInstant(TimeZone.UTC)?.minus(
                        it
                    )
                }
                binding.arrTime.text = arrivalDate?.time.toString()
                binding.depTime.text = departureDate?.time.toString()
                binding.flightTime.text = "${flightTime?.inWholeHours}.${
                    flightTime?.inWholeMinutes?.rem(
                        60
                    )
                }ч в пути"
            }
        }
    }

    companion object {
        private val DIFFUTIL = object : DiffUtil.ItemCallback<TicketUi>() {

            override fun areItemsTheSame(oldItem: TicketUi, newItem: TicketUi): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TicketUi, newItem: TicketUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}
