package com.example.navigationtest

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    var savedBundle: Bundle? = null
    var saveState: FragmentManager? = null

    companion object{
        lateinit var instance: App
        private set
    }
}