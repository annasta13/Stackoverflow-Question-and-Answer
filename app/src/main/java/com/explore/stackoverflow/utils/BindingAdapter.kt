package com.explore.stackoverflow.utils

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat

@BindingAdapter("android:text")
fun setDouble(view: TextInputEditText, value: Double?) {
    val viewText = view.text.toString()
    val firstChar = value?.toString()?.first()?.toString() ?: ""
    if (matchNumberPattern(firstChar)) {
        val decimalPattern = "/^\\d*\\.?\\d*\$/".toRegex()
        val newValue = if (value != null) {
            val text = value.toString()
            if (text.isNotEmpty() && text.matches(decimalPattern)) {
                getValueResult(value.toDouble())
            } else getValueResult(value)
        } else getValueResult(null)
        val initialText = value ?: ""
        val valueResult = newValue.toDoubleOrNull() ?: ""
        if (valueResult != initialText) view.setText(newValue)
    } else {
        if (viewText.isNotEmpty()) view.setText("")
    }
}

private fun getValueResult(value: Double?): String {
    val df = DecimalFormat("0.##")
    return value?.let { df.format(it) } ?: ""
}

private fun matchNumberPattern(text: String): Boolean {
    val numberPattern = "[0-9]".toRegex()
    return text.matches(numberPattern)
}

@InverseBindingAdapter(attribute = "android:text")
fun getDouble(view: TextInputEditText): Double? {
    val text = view.text.toString()
    return if (text.isBlank()) {
        null
    } else if (matchNumberPattern(text.first().toString())) {
        text.toDoubleOrNull()
    } else null
}