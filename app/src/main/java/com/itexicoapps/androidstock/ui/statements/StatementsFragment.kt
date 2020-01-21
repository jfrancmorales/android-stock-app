package com.itexicoapps.androidstock.ui.statements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.itexicoapps.androidstock.R

class StatementsFragment : Fragment() {

    private lateinit var statementsViewModel: StatementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        statementsViewModel =
            ViewModelProviders.of(this).get(StatementsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_statements, container, false)
        val textView: TextView = root.findViewById(R.id.text_statements)
        statementsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}