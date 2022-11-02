package com.example.yumarketforowners.presentation.util

import androidx.databinding.InverseMethod

object EditTextConverter {

    @InverseMethod("stringToInt")
    @JvmStatic
    fun intToString(value: Int): String = value.toString()

    @JvmStatic
    fun stringToInt(value: String): Int = if (value.isEmpty()) {
        0
    } else {
        value.toInt()
    }
}