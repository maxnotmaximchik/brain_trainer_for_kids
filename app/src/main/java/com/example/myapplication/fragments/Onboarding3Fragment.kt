package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.myapplication.utils.Constants.ARG_PARAM1
import com.example.myapplication.utils.Constants.ARG_PARAM2
import com.example.myapplication.databinding.FragmentOnboarding3Binding

class Onboarding3Fragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentOnboarding3Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboarding3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.progress = 100

        binding.buttonGetStarted.setOnClickListener {
            setFragmentResult("fragment_onboarding", bundleOf("next" to "onboarding_last"))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Onboarding3Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}