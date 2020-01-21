package com.itexicoapps.androidstock.ui.balances

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.itexicoapps.androidstock.R

class BalancesFragment : Fragment() {

    private lateinit var balancesViewModel: BalancesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        balancesViewModel =
            ViewModelProviders.of(this).get(BalancesViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_balances, container, false)
        /*val textView = root.findViewById<TextView>(R.id.text_balances)
        balancesViewModel.text.observe(this, Observer {
            textView.text = it
        })*/

        return root
    }
}
