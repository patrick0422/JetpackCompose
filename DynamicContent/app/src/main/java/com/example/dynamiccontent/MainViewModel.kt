package com.example.dynamiccontent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textFieldState = MutableLiveData("")

    fun onTextChanged(newValue: String) {
        textFieldState.value = newValue
    }
}