package com.itexicoapps.androidstock.extensions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

fun <T:AppCompatActivity> AppCompatActivity.launchActivity(context: Context, javaClass: Class<T>, args: Bundle? = null) {
    startActivity(Intent(context, javaClass), args)
}