package com.example.navigationtest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MySuperActivity"
    private val FRAGMENT_KEY = "frag_id_key"

    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate($savedInstanceState) called")

        initNavController()
    }

    private fun initNavController() {
        val navHostFragment = nav_host_fragment as NavHostFragment
        val graphInflater = navHostFragment.navController.navInflater

        val graph = graphInflater.inflate(R.navigation.main_graph)

        navController = navHostFragment.navController
        navHostFragment.childFragmentManager
        if (App.instance.savedBundle != null) {
            Log.d(TAG, "bundle: ${App.instance.savedBundle}")
            navController.restoreState(App.instance.savedBundle)
            graph.startDestination = R.id.thirdFragment
        }
        navController.graph = graph
        Log.d(TAG, "currentDestination: ${navController.currentDestination}")
    }

    fun saveState(){
        App.instance.savedBundle = navController.saveState()
        Log.d(TAG, "saveState() : ${App.instance.savedBundle}")
    }
}
