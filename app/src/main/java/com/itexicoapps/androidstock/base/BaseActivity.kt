package com.itexicoapps.androidstock.base

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.materialdesign.MaterialColors
import com.itexicoapps.androidstock.base.materialdesign.MaterialImages
import com.itexicoapps.androidstock.constants.*
import com.itexicoapps.androidstock.data.model.UserSession
import com.itexicoapps.androidstock.prefs
import com.itexicoapps.androidstock.ui.login.LoginActivity
import com.lc.skinService.repository.LCSkinServiceRepository

open class BaseActivity: AppCompatActivity() {

    var userSession: UserSession? = null
    lateinit var materialColors: MaterialColors
    lateinit var materialImages: MaterialImages

    lateinit var confFileName: String

    var skinRepository: LCSkinServiceRepository? = null
    var themeSelected = R.style.AppTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        //getAppCurrentTheme()
        setTheme(themeSelected)
        super.onCreate(savedInstanceState)
        validateUserSession()
    }

    private fun validateUserSession() {
        // use this method to add behavior to validate user
        if (prefs.contains(CONFIG_BUNDLE_FILE_NAME)) {
            //confFileName = prefs.getStringFromPrefs(CONFIG_BUNDLE_FILE_NAME).orEmpty()
           //prefs.removeFromPrefs(CONFIG_BUNDLE_FILE_NAME)
        } else {
            //confFileName = "bundledskinitexico"
        }
    }

    override fun onStart() {
        super.onStart()
        var title = SpannableString(supportActionBar!!.title)
        title.setSpan(ForegroundColorSpan(Color.WHITE),
            0,
            title.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        supportActionBar!!.title = title
    }

    // Dev Note: On the bundle conf json, an object called MaterialColors,
    // this object contains the minimal mount the color that we can add to show the
    // app according with Material Design Color Design; this Activity
    // will be use and apply changes method is triggered by the Children Object.
    open fun applyChanges(skin: HashMap<String,String>) {
        if (userSession != null) {
            materialColors = userSession!!.materialColors
            materialImages = userSession!!.materialImages
        } else {
            skin?.let {
                materialColors = MaterialColors(
                skin[M_PRIMARY].orEmpty(),
                skin[M_PRIMARY_VARIANT].orEmpty(),
                skin[M_ON_PRIMARY].orEmpty(),
                skin[M_ON_PRIMARY_VARIANT].orEmpty(),
                skin[M_SECONDARY].orEmpty(),
                skin[M_SECONDARY_VARIANT].orEmpty(),
                skin[M_ON_SECONDARY].orEmpty(),
                skin[M_ON_SECONDARY_VARIANT].orEmpty(),
                skin[M_BACKGROUND].orEmpty(),
                skin[M_BACKGROUND_VARIANT].orEmpty(),
                skin[M_ON_BACKGROUND].orEmpty(),
                skin[M_ON_BACKGROUND_VARIANT].orEmpty(),
                skin[M_SURFACE].orEmpty(),
                skin[M_ON_SURFACE].orEmpty(),
                skin[M_ON_SURFACE_VARIANT].orEmpty(),
                skin[M_ERROR].orEmpty(),
                skin[M_ON_ERROR].orEmpty())

                materialImages = MaterialImages(skin[LOGIN_LOGO_IMAGE].orEmpty(),
                    skin[POP_UP_WHITE_IMAGE].orEmpty(),
                    skin[NO_INFO_IMAGE].orEmpty(),
                    skin[APP_MENU_IMAGE].orEmpty())

                val currentSkin = prefs.gson.toJson(skin)

                userSession = UserSession(
                    isConfSaved = true,
                    userActive = false,
                    filename = confFileName,
                    materialColors = materialColors,
                    materialImages = materialImages,
                    currentSkin = currentSkin)
            }
        }
    }

    private fun getAppCurrentTheme() {
        var theme = prefs.getStringFromPrefs("current_theme")
        if (theme != null) {
            when (theme) {
                "Normal" -> {
                    theme = "Normal"
                    themeSelected = R.style.AppTheme
                }
                "Dark" -> {
                    theme = "Dark"
                    themeSelected = R.style.AppThemeDark
                }
                "Pink" -> {
                    theme = "Pink"
                    themeSelected = R.style.AppThemePink
                }
                "Orange" -> {
                    theme = "Orange"
                    themeSelected = R.style.AppThemeOrange
                }
                //Pending Rainbow support Theme
            }
            prefs.saveStringOnPrefs("current_theme", theme)
        } else {
            prefs.saveStringOnPrefs("current_theme", "Normal")
        }
    }

    private fun goToLogin() {
        if (this !is LoginActivity) {
            launchActivity(LoginActivity::class.java)
        }
    }

    fun <T:AppCompatActivity?> launchActivity(classType: Class<T>, args: Bundle? = null) {
        var forgotActivityIntent = Intent(this, classType)
        startActivity(forgotActivityIntent, args)
    }

    // Method to show an alert dialog for showing Chameleon Capabilities
    fun showDialog(){
        lateinit var dialog: AlertDialog
        val array = resources.getStringArray(R.array.theme_conf_file_names)
        val builder = AlertDialog.Builder(this)

        builder.setTitle(R.string.conf_alert_title)
        builder.setSingleChoiceItems(array, -1) { _, which ->
            var theme = array[which]
            prefs.saveStringOnPrefs("current_theme", theme)
            //getAppCurrentTheme()
            setTheme(themeSelected)
            /*with (skinRepository) {
                this?.applyBundleSkinLocal(confFileName)?.let {
                    userSession = null // as a example change Colors on command
                    prefs.saveStringOnPrefs(CONFIG_BUNDLE_FILE_NAME, confFileName)
                    applyChanges(it)
                }
            }*/
            dialog.dismiss()
        }

        dialog = builder.create()
        dialog.show()
    }
}