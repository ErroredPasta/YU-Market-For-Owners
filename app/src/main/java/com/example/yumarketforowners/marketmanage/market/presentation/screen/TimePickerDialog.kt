package com.example.yumarketforowners.marketmanage.market.presentation.screen

import android.content.Context
import android.view.LayoutInflater
import com.example.yumarketforowners.R
import com.example.yumarketforowners.databinding.DialogTimePickerBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.time.LocalTime

class TimePickerDialog(
    context: Context,
    layoutInflater: LayoutInflater,
    onPositiveButtonClicked: (LocalTime) -> Unit,
    onCancelButtonClicked: (() -> Unit)? = null
) {

    private val binding = DialogTimePickerBinding.inflate(layoutInflater)
    private val time
        get() = LocalTime.of(
            binding.dialogTimePicker.hour,
            binding.dialogTimePicker.minute
        )

    private val dialog = MaterialAlertDialogBuilder(context)
        .setView(binding.root)
        .setPositiveButton(R.string.confirm) { dialog, _ ->
            onPositiveButtonClicked(time)
            dialog.dismiss()
        }.setNeutralButton(R.string.cancel) { dialog, _ ->
            onCancelButtonClicked?.invoke()
            dialog.dismiss()
        }.create()

    fun show() = dialog.show()
}