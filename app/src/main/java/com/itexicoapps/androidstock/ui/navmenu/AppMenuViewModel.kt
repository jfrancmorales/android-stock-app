package com.itexicoapps.androidstock.ui.navmenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppMenuViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is NavMenu Fragment"
    }
    val text: LiveData<String> = _text
}
