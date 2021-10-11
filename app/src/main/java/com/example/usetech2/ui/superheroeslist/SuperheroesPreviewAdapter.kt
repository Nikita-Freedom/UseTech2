package com.example.usetech2.ui.superheroeslist

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.usetech2.network.Models
import timber.log.Timber

typealias ClickListener = (Models.SuperHero) -> Unit

class SuperheroesPreviewAdapter(
    private val clickListener: ClickListener
) : PagedListAdapter<Models.SuperHero, SuperHeroViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        Timber.d("Binding view holder at position $position")
        val photo = getItem(position)

        with(holder) {
            bind(photo)
            photo?.let {
                itemView.setOnClickListener {
                    clickListener(photo)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder =
        SuperHeroViewHolder.from(parent)


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Models.SuperHero>() {
            override fun areItemsTheSame(oldItem: Models.SuperHero, newItem: Models.SuperHero): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Models.SuperHero, newItem: Models.SuperHero): Boolean =
                oldItem == newItem
        }
    }
}