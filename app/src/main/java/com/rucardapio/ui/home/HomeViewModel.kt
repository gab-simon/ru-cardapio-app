package com.rucardapio.ui.home

import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rucardapio.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HomeViewModel : ViewModel() {
    private val currentDate = Date()
    private val formattedDate = formatDate(currentDate)

    private val _text = MutableLiveData<SpannableString>().apply {
        value = createFormattedText()
    }
    val text: LiveData<SpannableString> = _text

    private val _textsubtitle = MutableLiveData<String>().apply {
        value = "Confira o cardápio de hoje ($formattedDate)"
    }
    val textsubtitle: MutableLiveData<String> = _textsubtitle

    private fun formatDate(date: Date): String {
        val dateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
        return dateFormat.format(date)
    }
    private fun getColoredSpanned(text: String, color: Int): SpannableString {
        val spannable = SpannableString(text)
        spannable.setSpan(
            ForegroundColorSpan(Color.rgb(160,208,56)),
            "Olá,".length,
            spannable.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannable
    }

    private fun createFormattedText(): SpannableString {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        val greeting = when (hourOfDay) {
            in 0..11 -> "Olá, Bom Dia."
            in 12..17 -> "Olá, Boa Tarde."
            else -> "Olá, Boa Noite."
        }

        val color = when (hourOfDay) {
            in 0..11 -> R.color.teal_200
            in 12..17 -> R.color.teal_200
            else -> R.color.purple_500
        }

        return getColoredSpanned(greeting, color)
    }
}