package com.food.app.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object CustomBinding {

    @BindingAdapter("ImageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).apply(RequestOptions().circleCrop()).into(imageView)
    }
}