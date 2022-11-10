package com.example.yumarketforowners.presentation.screen.marketmanage

import android.content.Context
import com.example.yumarketforowners.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.time.DayOfWeek

class DayPickerDialog(
    context: Context,
    preCheckedDaysOfWeek: List<DayOfWeek>,
    onPositiveButtonClicked: (List<DayOfWeek>) -> Unit,
    onCancelButtonClicked: (() -> Unit)? = null
) {

    private val checkableDaysOfWeek = DayOfWeek.values().map {
        CheckableDayOfWeek(dayOfWeek = it, isChecked = it in preCheckedDaysOfWeek)
    }

    private val checkedDaysOfWeek
        get() = checkableDaysOfWeek.filter { it.isChecked }.map { it.dayOfWeek }

    private val dialog = MaterialAlertDialogBuilder(context)
        .setTitle(R.string.closed_days)
        .setMultiChoiceItems(
            R.array.days,
            checkableDaysOfWeek.map { it.isChecked }.toBooleanArray()
        ) { _, which, isChecked ->
            checkableDaysOfWeek[which].isChecked = isChecked
        }.setPositiveButton(R.string.confirm) { dialog, _ ->
            onPositiveButtonClicked(checkedDaysOfWeek)
            dialog.dismiss()
        }.setNeutralButton(R.string.cancel) { dialog, _ ->
            onCancelButtonClicked?.invoke()
            dialog.dismiss()
        }.create()

    fun show() = dialog.show()
}

private data class CheckableDayOfWeek(
    val dayOfWeek: DayOfWeek,
    var isChecked: Boolean = false
)