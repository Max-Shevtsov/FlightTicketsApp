package com.max.flightticketsapp.ui.flightsFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.max.flightticketsapp.R
import com.max.flightticketsapp.data.model.OfferUi
import com.max.flightticketsapp.databinding.ItemFlightToConcertBinding
import com.max.flightticketsapp.ui.searchFragment.PHUKET
import com.max.flightticketsapp.ui.searchFragment.SOCHI
import com.max.flightticketsapp.ui.searchFragment.STAMBUL

const val DIE_ANTWOORD =
    "https://sun9-77.userapi.com/impg/gjQYAPIdLWkVnyLm76x4IRExuRnru75hAyRpag/DowKreRDUvY.jpg?size=796x751&quality=95&sign=9b29e05df574ca296a413ced4ed512a7&type=album"
const val SOCKRAT_LERA =
    "https://sun9-17.userapi.com/impg/cTZRT0nVa53wEL1RH8m1YaLsFDzGsP8S5E36QQ/dFtJVlx5PKI.jpg?size=600x600&quality=95&sign=5fee107573c3c02aefe023b5f0f00e0a&type=album"
const val LAMPABIKT =
    "https://sun9-32.userapi.com/impg/rcYY4FSc5pkRdMZPWa87VZIma05-UuLjyMl_fg/LvF6w-TBkuA.jpg?size=225x225&quality=95&sign=fb9fcf69a42af44b406b133881ece468&type=album"

class FlightsToConcertAdapter() :
    ListAdapter<OfferUi, FlightsToConcertAdapter.ViewHolder>(DIFFUTIL) {

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

        fun bind(offerUi: OfferUi) {
            with(binding) {
                title.text = offerUi.title
                town.text = offerUi.town
                price.text = "От ${offerUi.price?.value} ₽"
                val roundingRadius = 16
                when (offerUi.id) {
                    1 -> Glide.with(this.root)
                        .load(DIE_ANTWOORD)
                        .transform(
                            CenterCrop(), RoundedCorners(roundingRadius)
                        )
                        .into(imageOfMusicGroup)

                    2 -> Glide.with(this.root)
                        .load(SOCKRAT_LERA)
                        .transform(
                            CenterCrop(), RoundedCorners(roundingRadius)
                        )
                        .into(imageOfMusicGroup)

                    3 -> Glide.with(this.root)
                        .load(LAMPABIKT)
                        .transform(
                            CenterCrop(), RoundedCorners(roundingRadius)
                        )
                        .into(imageOfMusicGroup)

                    else -> imageOfMusicGroup.setImageResource(R.drawable.ic_hot_tickets)
                }
            }
        }
    }

    companion object {
        private val DIFFUTIL = object : DiffUtil.ItemCallback<OfferUi>() {

            override fun areItemsTheSame(oldItem: OfferUi, newItem: OfferUi): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: OfferUi, newItem: OfferUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}
