package com.example.yumarketforowners.marketmanage.market.presentation.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.yumarketforowners.R
import com.example.yumarketforowners.marketmanage.market.presentation.extension.toString
import java.time.DayOfWeek

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