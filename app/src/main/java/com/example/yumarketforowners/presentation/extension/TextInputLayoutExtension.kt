package com.example.yumarketforowners.presentation.extension

import com.google.android.material.textfield.TextInputLayout

val TextInputLayout.text get() = editText!!.text.toString()