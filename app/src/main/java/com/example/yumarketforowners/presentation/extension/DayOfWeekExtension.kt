package com.example.yumarketforowners.presentation.extension

import android.content.Context
import com.example.yumarketforowners.R
import java.time.DayOfWeek

fun DayOfWeek.toStringResource() = when (this) {
    DayOfWeek.MONDAY -> R.string.monday
    DayOfWeek.TUESDAY -> R.string.tuesday
    DayOfWeek.WEDNESDAY -> R.string.wednesday
    DayOfWeek.THURSDAY -> R.string.thursday
    DayOfWeek.FRIDAY -> R.string.friday
    DayOfWeek.SATURDAY -> R.string.saturday
    DayOfWeek.SUNDAY -> R.string.sunday
}

fun List<DayOfWeek>.toString(
    context: Context,
    separator: CharSequence = ", "
) = joinToString(separator = separator) {
    context.getString(it.toStringResource())
}