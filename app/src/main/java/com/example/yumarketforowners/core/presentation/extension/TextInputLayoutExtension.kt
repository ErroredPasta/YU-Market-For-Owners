package com.example.yumarketforowners.core.presentation.extension

import com.google.android.material.textfield.TextInputLayout

val TextInputLayout.text get() = editText!!.text.toString()