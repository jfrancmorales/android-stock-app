package com.itexicoapps.androidstock.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.itexicoapps.androidstock.base.materialdesign.MaterialColors
import com.itexicoapps.androidstock.base.materialdesign.MaterialImages
import com.itexicoapps.androidstock.constants.USER_SESSION
import com.itexicoapps.androidstock.data.model.UserSession
import com.itexicoapps.androidstock.prefs

open class BaseFragment : Fragment() {

    var userSession: UserSession? = null
    lateinit var materialColors: MaterialColors
    lateinit var materialImages: MaterialImages

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userSession = if (prefs.contains(USER_SESSION)) {
            prefs.getObjectFromPrefs(USER_SESSION, UserSession::class.java)
        } else {
            null
        }
    }

    override fun onStart() {
        super.onStart()
        if (userSession != null) {
            applyChanges()
        }
    }

    open fun applyChanges() {
        materialColors = userSession!!.materialColors
        materialImages = userSession!!.materialImages
    }

    open fun <T:AppCompatActivity> launchActivity(classType: Class<T>, args: Bundle? = null) {
        activity!!.startActivity(Intent(this.context, classType), args)
    }
}