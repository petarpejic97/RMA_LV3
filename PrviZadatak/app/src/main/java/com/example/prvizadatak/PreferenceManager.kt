package com.example.prvizadatak

import android.content.Context

class PreferenceManager {
    companion object {
        const val PREFS_FILE = "MyPreferences"
        const val PREFS_KEY_USERNAME = "Petar"
    }
    fun saveCounter(counter: String) {
        val sharedPreferences = PrviZadatak.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString("counter", counter)
        editor.apply()
    }
    fun saveColor(color: String) {
        val sharedPreferences = PrviZadatak.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString("color", color)
        editor.apply()
    }
    fun retrieveCounter(): String? {
        val sharedPreferences = PrviZadatak.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString("counter", "0")
    }
    fun retrieveColor(): String? {
        val sharedPreferences = PrviZadatak.ApplicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString("color", "GR")
    }
}