package com.itexicoapps.androidstock.ui.navmenu.menuitems.payoff

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import com.itexicoapps.androidstock.R
import com.itexicoapps.androidstock.base.BaseActivity
import kotlinx.android.synthetic.main.activity_payoff_request.*
import java.util.*

class PayoffRequestActivity : BaseActivity() {

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
        setContentView(R.layout.activity_payoff_request)
        supportActionBar!!.title = getString(R.string.payoff_request)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)

        estimated_payoff_date.setOnClickListener {
            showDatePicker(estimated_payoff_date)
        }

        need_payoff_return_date.setOnClickListener {
            showDatePicker(need_payoff_return_date)
        }
    }

    private fun showDatePicker(editText: EditText) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        var message = if (editText.id == R.id.estimated_payoff_date) {
            getString(R.string.example_date_estimated_payoff)
        } else {
            getString(R.string.example_need_payoff_date)
        }

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            // Display Selected date in textbox
            // TODO add the text corresponding to the editTextId
            editText.setText("$message $monthOfYear/$dayOfMonth/$year")
        }, year, month, day)

        dpd.show()
    }
}
