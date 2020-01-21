package com.itexicoapps.androidstock.ui.navmenu

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseFragment
import com.itexicoapps.androidstock.constants.USER_SESSION
import com.itexicoapps.androidstock.prefs
import com.itexicoapps.androidstock.ui.login.LoginActivity
import com.itexicoapps.androidstock.ui.navmenu.menuitems.accountnotes.AccountNotesActivity
import com.itexicoapps.androidstock.ui.navmenu.menuitems.help.HelpActivity
import com.itexicoapps.androidstock.ui.navmenu.menuitems.payinfo.PaymentInformationActivity
import com.itexicoapps.androidstock.ui.navmenu.menuitems.payoff.PayoffRequestActivity
import com.itexicoapps.androidstock.ui.navmenu.menuitems.profile.ProfileActivity
import kotlinx.android.synthetic.main.fragment_nav_menu.*

class AppMenuFragment : BaseFragment() {

    private lateinit var navMenuViewModel: AppMenuViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        navMenuViewModel =
            ViewModelProviders.of(this).get(AppMenuViewModel::class.java)
        navMenuViewModel.text.observe(this, Observer {
            // TODO implement ViewModel
        })

        return inflater.inflate(R.layout.fragment_nav_menu, container, false)
    }

    override fun onStart() {
        super.onStart()
        profile_clickable_layout.setOnClickListener{
            showToast("Profile")
            launchActivity(ProfileActivity::class.java)
        }
        payment_info_clickable_layout.setOnClickListener {
            // TODO Navigate to Payment Info
            showToast("Payment Info")
            launchActivity(PaymentInformationActivity::class.java)
        }
        bank_info_clickable_layout.setOnClickListener {
            // TODO Navigate to Bank Info
            showToast("Bank Info")
        }
        account_notes_clickable_layout.setOnClickListener {
            // TODO Navigate to Bank Info
            launchActivity(AccountNotesActivity::class.java)
            showToast("Account Notes")
        }
        payoff_clickable_layout.setOnClickListener {
            // TODO Navigate to Payoff Info
            launchActivity(PayoffRequestActivity::class.java)
            showToast("Payoff info")
        }
        about_clickable_layout.setOnClickListener {
            // TODO Navigate to About
            showToast("About")
        }
        help_clickable_layout.setOnClickListener {
            // TODO Navigate to Help
            launchActivity(HelpActivity::class.java)
            showToast("Help")
        }
        logout_clickable_layout.setOnClickListener {
            showConfirmationDialog()
        }
    }



    private fun showConfirmationDialog() {
        val dialogBuilder = activity?.let { AlertDialog.Builder(it) }
        dialogBuilder!!.setTitle(R.string.menu_dialog_title)
            .setMessage(R.string.menu_dialog_message)
            .setPositiveButton(R.string.button_dialog_positive) { dialog, _ ->
                dialog.dismiss()
                prefs.removeFromPrefs(USER_SESSION)
                launchActivity(LoginActivity::class.java)
                activity!!.finish()
            }.setNegativeButton(R.string.button_dialog_negative) { dialog, _ ->
                dialog.dismiss()
            }.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this.context, "$message under Construction", Toast.LENGTH_SHORT).show()
    }
}
