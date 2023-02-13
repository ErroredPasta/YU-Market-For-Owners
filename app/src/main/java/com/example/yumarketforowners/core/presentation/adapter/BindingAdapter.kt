package com.example.yumarketforowners.core.presentation.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.yumarketforowners.core.presentation.extension.load

@BindingAdapter(value = ["imageUrl", "cornerRadius"], requireAll = false)
fun setImageByUrl(imageView: ImageView, imageUri: String?, corner: Float) {
    if (imageUri == null) return

    imageView.load(imageUri, corner)
}


@BindingAdapter("showIf")
fun showIf(view: View, condition: Boolean) {
    view.visibility = if (condition) {
        View.VISIBLE
    } else {
        View.GONE
    }
}