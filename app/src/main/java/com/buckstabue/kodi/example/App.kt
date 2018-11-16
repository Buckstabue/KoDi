package com.buckstabue.kodi.example

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        lateinit var context: Context
            private set
    }

    override fun onCreate() {
        App.context = this
        super.onCreate()
    }
}
