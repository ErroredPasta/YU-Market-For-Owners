package com.example.yumarketforowners.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.yumarketforowners.R
import com.example.yumarketforowners.presentation.extension.load
import com.example.yumarketforowners.presentation.extension.toString
import java.time.DayOfWeek

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

@BindingAdapter("daysOfWeek")
fun setDaysOfWeek(textView: TextView, daysOfWeek: List<DayOfWeek>?) {
    if (daysOfWeek == null) return

    val context = textView.context

    textView.text = if (daysOfWeek.isEmpty()) {
        context.getString(R.string.no_closed_days)
    } else {
        daysOfWeek.toString(context = context)
    }
}