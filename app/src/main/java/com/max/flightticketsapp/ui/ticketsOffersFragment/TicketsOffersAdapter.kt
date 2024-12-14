package com.max.flightticketsapp.ui.ticketsOffersFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView

import com.max.flightticketsapp.data.model.TicketsOfferUi
import com.max.flightticketsapp.databinding.ItemTicketsOffersBinding

const val STAMBUL =
    "https://sun9-8.userapi.com/impg/ded-Uj856OKIJeDKFqOcztVEpcwcYoonkDth4w/HrBJGmQw09o.jpg?size=862x608&quality=95&sign=8a629985cc7dbdbd3b2f4ad7dbac6778&type=album"
const val SOCHI =
    "https://sun9-31.userapi.com/impg/DAVWDBpnlh0WYXhxs5PGb9BrGLVJqDy4lPfvQA/H6N5VUfpO7c.jpg?size=301x168&quality=95&sign=798d2312bb3748e502e842f94f603690&type=album"
const val PHUKET =
    "https://sun9-5.userapi.com/impg/8P31fEE-BJyQnSnsceEeVkm6T_aAZsqzkg3nZA/jRWc1_iCpJ4.jpg?size=600x352&quality=95&sign=c3397b1f70925327b60abf10395f42d3&type=album"

class TicketsOffersAdapter() :
    ListAdapter<TicketsOfferUi, TicketsOffersAdapter.ViewHolder>(DIFFUTILS) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTicketsOffersBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ticketsOffer = getItem(position)
        holder.bind(ticketsOffer)

    }



    class ViewHolder(
        private val binding: ItemTicketsOffersBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ticketsOffer: TicketsOfferUi) {
            with(binding) {
                flightCompany.text = ticketsOffer.title
                price.text = "${ticketsOffer.price?.value} ₽"
                timeRange.text = ticketsOffer.timeRange.joinToString(separator = " ")
//                val roundingRadius = 16
//                when (recomendation) {
//                    "Стамбул" -> Glide.with(this.root)
//                        .load(STAMBUL)
//                        .transform(
//                            CenterCrop(), RoundedCorners(roundingRadius)
//                        )
//                        .into(imageOfMusicGroup)
//
//                    "Сочи" -> Glide.with(this.root)
//                        .load(SOCHI)
//                        .transform(
//                            CenterCrop(), RoundedCorners(roundingRadius)
//                        )
//                        .into(imageOfMusicGroup)
//
//                    "Пхукет" -> Glide.with(this.root)
//                        .load(PHUKET)
//                        .transform(
//                            CenterCrop(), RoundedCorners(roundingRadius)
//                        )
//                        .into(imageOfMusicGroup)
//
//                    else -> imageOfMusicGroup.setImageResource(R.drawable.ic_hot_tickets)
//                }


            }
        }
    }
    companion object {
        private val DIFFUTILS = object : DiffUtil.ItemCallback<TicketsOfferUi>() {

            override fun areItemsTheSame(oldItem: TicketsOfferUi, newItem: TicketsOfferUi): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TicketsOfferUi, newItem: TicketsOfferUi): Boolean {
                return oldItem == newItem
            }
        }
    }
}
