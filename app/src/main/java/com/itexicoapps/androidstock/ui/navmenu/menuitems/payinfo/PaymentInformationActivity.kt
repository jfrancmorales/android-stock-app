package com.itexicoapps.androidstock.ui.navmenu.menuitems.payinfo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import kotlinx.android.synthetic.main.activity_payment_information.*

class PaymentInformationActivity : BaseActivity() {

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
        setContentView(R.layout.activity_payment_information)
        supportActionBar!!.title = getString(R.string.payment_info_title)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)

        future.setOnClickListener {
            //TODO Navigate to Loan Details
            showToast("Loan Details")
            startActivity(Intent(this, LoanDetailActivity::class.java))
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, "$message Under Construction", Toast.LENGTH_SHORT).show()
    }
}
