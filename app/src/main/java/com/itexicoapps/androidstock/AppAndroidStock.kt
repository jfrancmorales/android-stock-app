package com.itexicoapps.androidstock

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.itexicoapps.androidstock.base.PreferencesManager

val prefs: PreferencesManager by lazy {
    AppAndroidStock.prefs!!
}

class AppAndroidStock: Application() {

    companion object {
        var prefs: PreferencesManager? = null
    }

    override fun onCreate() {
        prefs = PreferencesManager(applicationContext)
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)


        /*LiftCommerce.setup(
            "987654321",
            "",
            true,
            "CLOUDPAY",
            "https://api.cloudpayments.com/",
            "5cc31beb901a2e00017617f85bca2d1262824dc6940d1c2213844d0e",
            "",
            "CLOUDPAY",
            "v1"
        )*/
    }

}