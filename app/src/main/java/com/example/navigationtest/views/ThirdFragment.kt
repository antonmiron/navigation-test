package com.example.navigationtest.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationtest.App
import com.example.navigationtest.MainActivity

import com.example.navigationtest.R
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment() {
    private val TAG = this::class.java.name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_finish.setOnClickListener {
           // App.instance.savedBundle = findNavController().saveState()
            (requireActivity() as MainActivity).saveState()
            requireActivity().finishAfterTransition()
        }
        btn_back.setOnClickListener { requireActivity().onBackPressed() }

        btn_save.setOnClickListener { (requireActivity() as MainActivity).saveState() }
    }

}
