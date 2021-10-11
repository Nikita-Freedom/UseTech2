package com.example.usetech2.ui.superheroesbiography

import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.usetech2.R
import com.example.usetech2.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_superhero_biography.*

class SuperheroBiography :  BaseFragment<Boolean, SuperheroBiographyViewModel>() {
    override fun handleState(state: Boolean) {}
    override fun getLayout(): Int = R.layout.fragment_superhero_biography

    override fun onCreateCompleted() {
        setHasOptionsMenu(true)
        createViewModel(SuperheroBiographyViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        bindBundle()
    }

    private fun bindBundle() {
        arguments?.apply {
            SuperheroBiographyArgs.fromBundle(this).apply {
                val imgUri = ivmage.toUri().buildUpon().scheme("https").build()
                iv_biography_card_image.setImageURI(imgUri)
                context?.let {
                    Glide.with(it)
                        .load(imgUri)
                        .apply(
                            RequestOptions()
                                .placeholder(R.drawable.loading_animation)
                                .error(R.drawable.ic_broken_image)
                        )
                        .into(iv_biography_card_image)
                }

                tv_full_name.text = tvName
                tv_aliases.text = tvAllies
                tv_relatives.text = tvRelatives
            }
        }
    }

}


