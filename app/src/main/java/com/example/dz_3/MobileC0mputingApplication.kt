package com.example.dz_3

import android.app.Application
import android.content.Context

class MobileC0mputingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}