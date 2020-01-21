package com.itexicoapps.androidstock.ui.navmenu.menuitems.help

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import kotlinx.android.synthetic.main.activity_help.*

class HelpActivity : BaseActivity() {

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
        setContentView(R.layout.activity_help)
        supportActionBar!!.title = getString(R.string.help_title)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)

        account_number_clickable_layout.setOnClickListener {
            // TODO Navigate to Transaction Description
            startActivity(Intent(this, HelpTransactionDescActivity::class.java))
        }
    }
}