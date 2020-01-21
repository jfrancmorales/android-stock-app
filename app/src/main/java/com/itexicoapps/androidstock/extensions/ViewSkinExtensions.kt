package com.itexicoapps.androidstock.extensions

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.Window
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.itexicoapps.androidstock.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout
import com.lc.skinService.repository.setImageLocal

/**
 * Extension File to simplify setting color for usage with Chameleon Library components
 * over general views
 */

/**
 * Basic extension method syntax example,
 * Param variable, any value that you need to add and or change.
 * returns view id as String
 */
fun View.someColorChangeMethod(variable: String): String {
    return this.id.toString()
}

/**
 * Window extension method to change background color according to Chameleon conf
 */
fun View.applySkinBackground(backgroundColor: String) {
    with(this) {
        background = ColorDrawable(Color.parseColor(backgroundColor))
    }
}

/**
 * Window extension method to change background color according to Chameleon conf
 */
fun Window.applySkinStyle(statusColor: String, navBarColor: String) {
    with(this) {
        statusBarColor = Color.parseColor(statusColor)
        navigationBarColor = Color.parseColor(navBarColor)
    }
}

/**
 * ActionBar extension method to change background color according to Chameleon conf
 */
fun ActionBar.applySkinStyle(color: String) {
    this.height
    with (this) {
        this.setBackgroundDrawable(ColorDrawable(Color.parseColor(color)))
    }
}

/**
 * ConstraintLayout extension method to change background color
 */
fun ConstraintLayout.applySkinStyle(color: String) {
    this.background = ColorDrawable(Color.parseColor(color))
}

/**
 * ConstraintLayout extension method to change background color
 */
fun LinearLayout.applySkinStyle(color: String) {
    this.background = ColorDrawable(Color.parseColor(color))
}

/**
 * ProgressBar extension method to change background color
 */
fun ProgressBar.applySkinStyle(color: String) {
    this.background = ColorDrawable(Color.parseColor(color))
}

/**
 * ProgressBar extension method to change background color
 */
fun TextView.applySkinStyle(disabledColor: String, normalColor: String) {
    val states = arrayOf(
        intArrayOf(-android.R.attr.state_enabled), // unchecked
        intArrayOf(android.R.attr.state_enabled)                             // default
    )
    /**
     * colors to apply according to te states
     */
    val colors = intArrayOf(
        Color.parseColor(disabledColor),
        Color.parseColor(normalColor)
    )

    val colorStates = ColorStateList(states, colors)
    setTextColor(colorStates)
}

/**
 * TextInputLayout extension method to change background color
 */
fun TextInputLayout.applySkinStyle(strokeColor: String,
                                   hintColor: String,
                                   errorColor: String) {
    this.boxStrokeColor = Color.parseColor(strokeColor)

    val states = arrayOf(
        intArrayOf(-android.R.attr.state_enabled), // enabled
        intArrayOf(android.R.attr.state_focused), // focused
        intArrayOf()                                // default
    )
    val colors = intArrayOf(
        Color.parseColor(hintColor),
        Color.parseColor(hintColor),
        Color.parseColor(strokeColor)
    )

    val colorsError = intArrayOf(
        Color.parseColor(errorColor),
        Color.parseColor(errorColor),
        Color.parseColor(errorColor)
    )

    defaultHintTextColor = ColorStateList(states, colors)
    setErrorTextColor(ColorStateList(states, colorsError))
}

/**
 * Button extension method to change background color
 */
fun Button.applySkinColors(backgroundColor: String,
                           textColor: String,
                           secondaryColor: String,
                           pressedColor: String ) {
    with(this) {
        setTextColor(Color.parseColor(textColor))
        var states = arrayOf(
            intArrayOf(android.R.attr.state_enabled), // enabled
            intArrayOf(-android.R.attr.state_enabled), // disabled
            intArrayOf(android.R.attr.state_pressed) // pressed
        )
        val colors = intArrayOf(
            Color.parseColor(textColor),
            Color.parseColor(secondaryColor),
            Color.parseColor(pressedColor)
        )
        setHintTextColor(ColorStateList(states, colors))
        var statesBackground = arrayOf(
            intArrayOf(android.R.attr.state_enabled), // enabled
            intArrayOf(-android.R.attr.state_enabled), // disabled
            intArrayOf(android.R.attr.state_pressed) // pressed
        )
        val colorsBackground = intArrayOf(
            Color.parseColor(backgroundColor),
            Color.parseColor(secondaryColor),
            Color.parseColor(pressedColor)
        )
        setBackgroundResource(R.drawable.selector_button)
        background.mutate()
        backgroundTintList = ColorStateList(statesBackground, colorsBackground)
    }
}

/**
 * BottomNavigationView extension method to change background color
 */
fun BottomNavigationView.applySkinStyle(colorBackground: String,
                                        navBarColor: String,
                                        onSelected: String,
                                        navBarTintColor: String) {
    /**
     * the states of bottom navigation view
     */
    val states = arrayOf(
        intArrayOf(-android.R.attr.state_checked), // unchecked
        intArrayOf(android.R.attr.state_checked), // checked
        intArrayOf()                                // default
    )
    /**
     * colors to apply according to te states
     * variables to be defined
     */
    val colors = intArrayOf(
        Color.parseColor(colorBackground),
        Color.parseColor(onSelected),
        Color.parseColor(navBarTintColor)
    )

    /**
     * create the ColorStateList instance with the configuration above
     */
    val color = ColorStateList(states, colors)

    with (this) {
        setBackgroundColor(Color.parseColor(navBarColor))
        itemTextColor = color
        itemIconTintList = color
    }
}

/**
 * ImageView extension method to change image
 */
fun ImageView.addImage(isRemoteUrl: Boolean, filename: String) {
    //validate if remote and
    // TODO handling Remote Url Image recommendation on Chameleon team, is to use the preferred
    // Image handling library. for the moment will only do local.
    if (!isRemoteUrl) {
        this.setImageLocal(filename)
    } else {
        //TODO add image Library
    }
}

/**
 * Drawable extension method to change icon and colors
 */
fun Drawable.applySkinStyle(color: String) {
    setTint(Color.parseColor(color))

}


