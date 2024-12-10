package com.max.flightticketsapp.ui.flightsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.max.flightticketsapp.data.model.Offer
import com.max.flightticketsapp.databinding.ItemFlightToConcertBinding

class FlightsToConcertAdapter() :
    ListAdapter<Offer, FlightsToConcertAdapter.ViewHolder>(DIFFUTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFlightToConcertBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val flightToConcert = getItem(position)
        holder.bind(flightToConcert)

    }

    class ViewHolder(
        private val binding: ItemFlightToConcertBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(offer: Offer) {
            with(binding) {
                title.text = offer.title
                town.text = offer.town
                price.text = "От ${offer.price?.value.toString()}"
            }
        }
    }

    companion object {
        private val DIFFUTIL = object : DiffUtil.ItemCallback<Offer>() {

            override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
                return oldItem == newItem
            }
        }
    }
}
