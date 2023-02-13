package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("opponentName")
fun setOpponentName(textView: TextView, name: String) {
    textView.text = if (name.length > 3) {
        name.substring(0..3) + "***"
    } else {
        name[0] + "***"
    }
}