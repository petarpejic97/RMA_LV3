package com.example.prvizadatak

import android.app.Application
import android.content.Context

class PrviZadatak : Application() {
    companion object {
        lateinit var ApplicationContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}