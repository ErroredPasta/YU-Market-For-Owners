package com.example.yumarketforowners.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.yumarketforowners.presentation.extension.load

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


@BindingAdapter("opponentName")
fun setOpponentName(textView: TextView, name: String) {
    textView.text = if (name.length > 3) {
        name.substring(0..3) + "***"
    } else {
        name[0] + "***"
    }
}