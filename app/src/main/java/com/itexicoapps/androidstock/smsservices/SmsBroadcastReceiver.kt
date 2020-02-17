package com.itexicoapps.androidstock.smsservices

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

class SmsBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent?.action) {
            val bundle = intent.extras
            val status = bundle?.get(SmsRetriever.EXTRA_STATUS) as Status

            when (status.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    val msg = bundle.get(SmsRetriever.EXTRA_SMS_MESSAGE) as String
                    print("Received message : $msg")
                }
                CommonStatusCodes.TIMEOUT -> {
                    // Handle Timeout error
                }
            }
        }
    }
}