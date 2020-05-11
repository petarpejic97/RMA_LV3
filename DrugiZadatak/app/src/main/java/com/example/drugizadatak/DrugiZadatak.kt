package com.example.drugizadatak

import android.app.Application
import android.content.Context

class DrugiZadatak : Application() {
    companion object {
        lateinit var ApplicationContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}
