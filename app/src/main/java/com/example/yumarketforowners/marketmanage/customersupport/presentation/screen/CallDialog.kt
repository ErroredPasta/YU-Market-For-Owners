package com.example.yumarketforowners.marketmanage.customersupport.presentation.screen

import android.content.Context
import com.example.yumarketforowners.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CallDialog(
    context: Context,
    title: String? = null,
    message: String? = null,
    onPositiveButtonClicked: () -> Unit,
    onCancelButtonClicked: (() -> Unit)? = null
) {

    private val dialog = createBuidler(
        context = context,
        title = title,
        message = message,
        onPositiveButtonClicked = onPositiveButtonClicked,
        onCancelButtonClicked = onCancelButtonClicked
    ).create()

    private fun createBuidler(
        context: Context,
        title: String? = null,
        message: String? = null,
        onPositiveButtonClicked: () -> Unit,
        onCancelButtonClicked: (() -> Unit)?
    ) : MaterialAlertDialogBuilder {
        val builder = MaterialAlertDialogBuilder(context)
            .setPositiveButton("통화 걸기") { dialog, _ ->
                onPositiveButtonClicked()
                dialog.dismiss()
            }


        title?.let { builder.setTitle(it) }
        message?.let { builder.setMessage(it) }
        onCancelButtonClicked?.let {
            builder.setNeutralButton(R.string.cancel) { dialog, _ ->
                onCancelButtonClicked()
                dialog.dismiss()
            }
        }

        return builder
    }

    fun show() = dialog.show()
}