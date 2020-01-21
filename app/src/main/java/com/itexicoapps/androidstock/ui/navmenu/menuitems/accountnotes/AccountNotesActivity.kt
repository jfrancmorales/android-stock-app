package com.itexicoapps.androidstock.ui.navmenu.menuitems.accountnotes

import android.os.Bundle
import android.view.MenuItem
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity

class AccountNotesActivity : BaseActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_notes)
        supportActionBar!!.title = getString(R.string.account_notes)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)
    }
}
