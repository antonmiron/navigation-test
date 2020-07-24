package com.example.navigationtest

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment

class MyNavHostFragment(): NavHostFragment(){
    private val TAG = this::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate($savedInstanceState) called")
        super.onCreate(savedInstanceState)
    }
}