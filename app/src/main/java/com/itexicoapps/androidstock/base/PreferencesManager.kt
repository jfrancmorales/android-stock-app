package com.itexicoapps.androidstock.base

import android.content.Context
import android.content.SharedPreferences
import com.itexicoapps.androidstock.constants.*
import com.google.gson.GsonBuilder

class PreferencesManager (context: Context) {
    private val sharedPrefs: SharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, PRIVATE_MODE)
    private val editor = sharedPrefs.edit()
    val gson = GsonBuilder().create()

    fun contains(stringKey: String): Boolean {
        return sharedPrefs.contains(stringKey)
    }

    fun saveBooleanOnPrefs(stringKey: String, booleanValue: Boolean) {
        editor.putBoolean(stringKey, booleanValue)
        editor.apply()
    }

    fun saveStringOnPrefs(stringKey: String, stringValue: String) {
        editor.putString(stringKey, stringValue)
        editor.apply()
    }

    fun <T:Any?> saveObjectOnPrefs(stringKey: String, t: T) {
        if (sharedPrefs.contains(stringKey)) {
            removeFromPrefs(stringKey)
        }
        editor.putString(stringKey, gson.toJson(t))
        editor.apply()
    }

    fun <T:Any?> getObjectFromPrefs(stringValue: String, classType: Class<T>): T? {
        val objectString = this.getStringFromPrefs(stringValue)
        return (if (objectString != null) gson.fromJson(objectString, classType) else objectString) as T
    }

    fun removeFromPrefs(stringKey: String) {
        if (sharedPrefs.contains(stringKey)) {
            editor.remove(stringKey).apply()
        }
    }

    fun getStringFromPrefs(stringValue: String): String? {
        return sharedPrefs.getString(stringValue, null)
    }
}