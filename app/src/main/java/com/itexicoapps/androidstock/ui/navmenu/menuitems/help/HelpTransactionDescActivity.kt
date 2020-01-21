package com.itexicoapps.androidstock.ui.navmenu.menuitems.help

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import com.itexicoapps.androidstock.ui.login.ContactActivity
import kotlinx.android.synthetic.main.activity_help_transaction_desc.*

class HelpTransactionDescActivity : BaseActivity() {

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
        setContentView(R.layout.activity_help_transaction_desc)
        supportActionBar!!.title = getString(R.string.help_title)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)

        contact_clickable_text.setOnClickListener {
            var contactActivityIntent = Intent(this, ContactActivity::class.java)
            startActivity(contactActivityIntent)
        }
    }
}
