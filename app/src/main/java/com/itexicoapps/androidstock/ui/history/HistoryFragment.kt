package com.itexicoapps.androidstock.ui.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.itexicoapps.androidstock.R
import kotlinx.android.synthetic.main.history_test_layout.view.*

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyViewModel =
            ViewModelProviders.of(this).get(HistoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_history, container, false)
        // TODO validate correctly with recycler view & adapter
        addOnClickToRow(root)
        return root
    }

    private fun addOnClickToRow(parent: View) {
        parent.row_1.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_2.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_3.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_4.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_5.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_6.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_7.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_8.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_9.setOnClickListener { goToPaymentDetail(parent) }
        parent.row_10.setOnClickListener { goToPaymentDetail(parent) }
    }

    private fun goToPaymentDetail(view: View) {
        // TODO History Activity Navigation and verify what needs to be passed
        view.context.startActivity(Intent(view.context, HistoryDetailActivity::class.java))
    }
}