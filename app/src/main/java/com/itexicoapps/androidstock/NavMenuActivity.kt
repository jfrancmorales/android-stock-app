package com.itexicoapps.androidstock

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.itexicoapps.androidstock.base.BaseActivity
import com.itexicoapps.androidstock.extensions.*
import kotlinx.android.synthetic.main.activity_nav_menu.*
import kotlinx.android.synthetic.main.view_welcome_dialog.*

class NavMenuActivity : BaseActivity() {

    lateinit var dialogView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_menu)

        supportActionBar?.hide()

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_payments,
                R.id.navigation_history, R.id.navigation_statements,
                R.id.navigation_balances, R.id.navigation_menu
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
        dialogView = layoutInflater.inflate(R.layout.view_welcome_dialog, null)
        showWelcomeDialog()
    }

    private fun applyChanges() {
        userSession.let {
            materialColors = userSession!!.materialColors
            materialImages = userSession!!.materialImages
            applySkinToAlertDialog()
            nav_view.applySkinStyle(materialColors.colorOnPrimaryVariant,
                materialColors.colorOnSecondary,
                materialColors.colorOnSecondaryVariant,
                materialColors.colorOnPrimary)

        }
    }

    private fun applySkinToAlertDialog() {
        dialogView = layoutInflater.inflate(R.layout.view_welcome_dialog, null)
        var opaqueBackground = dialogView.findViewById<LinearLayout>(R.id.opaque_background)
        opaqueBackground.background = ColorDrawable(Color.parseColor(materialColors.colorPrimary))
        var xClose = dialogView.findViewById<ImageView>(R.id.close_image_view)
        xClose.drawable.setTint(Color.parseColor(materialColors.colorOnPrimary))
        var imageLogo = dialogView.findViewById<ImageView>(R.id.company_logo)
        imageLogo.addImage(false, materialImages.whitePopupImage)
        var welcomeTitle = dialogView.findViewById<TextView>(R.id.welcome_text)
        welcomeTitle.setTextColor(Color.parseColor(materialColors.colorOnPrimary))
        var welcomeMessage = dialogView.findViewById<TextView>(R.id.welcome_message_text)
        welcomeMessage.setTextColor(Color.parseColor(materialColors.colorOnPrimary))
        var appVersionLabel = dialogView.findViewById<TextView>(R.id.app_version_label)
        appVersionLabel.setTextColor(Color.parseColor(materialColors.colorOnPrimary))
    }

    private fun showWelcomeDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(dialogView)
        dialog.setTitle(null)

        val closeButton = dialog.close_image_view
        closeButton.setOnClickListener{
            dialog.dismiss()
        }

        dialog.show()

    }

    override fun onSupportNavigateUp() = findNavController(R.id.nav_view).navigateUp()
}
