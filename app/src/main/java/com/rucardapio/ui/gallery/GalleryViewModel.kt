package com.rucardapio.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "\uD83C\uDF7D️ Tenha o cardápio sempre à mão adicionando o widget do aplicativo! \uD83D\uDE0B"
    }
    val text: LiveData<String> = _text
}