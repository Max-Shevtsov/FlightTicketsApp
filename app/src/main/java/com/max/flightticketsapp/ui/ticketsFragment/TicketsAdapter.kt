package com.max.flightticketsapp.ui.ticketsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.data.model.Ticket
import com.max.flightticketsapp.databinding.ItemTicketsBinding
import kotlinx.datetime.DateTimePeriod
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.plus

class TicketsAdapter() :
    ListAdapter<Ticket, TicketsAdapter.ViewHolder>(DIFFUTIL) {

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

        fun bind(ticket: Ticket) {
            with(binding) {
                binding.price.text = ticket.price?.value.toString()

                binding.arrTime.text =
                    ticket.arrival?.date?.let { LocalDateTime.parse(it).time.toString() }
                binding.arrAirport.text = ticket.arrival?.airport

                binding.depTime.text =
                    ticket.departure?.date?.let { LocalDateTime.parse(it).time.toString() }
                binding.depAirport.text = ticket.departure?.airport

                binding.flightTime.text
            }
        }
    }

    companion object {
        private val DIFFUTIL = object : DiffUtil.ItemCallback<Ticket>() {

            override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
                return oldItem == newItem
            }
        }
    }
}
