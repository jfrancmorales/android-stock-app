package com.itexicoapps.androidstock.ui.statements

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StatementsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Statements Fragment"
    }
    val text: LiveData<String> = _text
}