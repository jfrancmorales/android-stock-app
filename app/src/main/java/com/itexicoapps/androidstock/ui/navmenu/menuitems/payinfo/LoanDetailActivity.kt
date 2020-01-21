package com.itexicoapps.androidstock.ui.navmenu.menuitems.payinfo

import android.os.Bundle
import android.view.MenuItem
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity

class LoanDetailActivity : BaseActivity() {

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
        setContentView(R.layout.activity_loan_detail)
        supportActionBar!!.title = getString(R.string.loan_details_title)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)
    }
}
