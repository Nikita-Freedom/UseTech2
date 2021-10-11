package com.example.usetech2.ui.superheroeslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.usetech2.R
import com.example.usetech2.network.Models
import kotlinx.android.synthetic.main.item_superhero.view.*

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    @SuppressLint("SetTextI18n")
    fun bind(superHero: Models.SuperHero?) {
        superHero?.apply {
            val imgUri = image.url
            itemView.apply {
                Glide.with(iv_card_image.context)
                    .load(imgUri)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .into(iv_card_image)
                tv_card_name.text = name
                tv_card_publisher.text = "by ${biography.publisher}"
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup): SuperHeroViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.item_superhero, parent, false)

            return SuperHeroViewHolder(view)
        }
    }

}