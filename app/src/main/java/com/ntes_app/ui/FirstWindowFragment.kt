package com.ntes_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.databinding.FragmentFirstWindowBinding
import com.ntes_app.onboarding_fragments.OnboardingFragment
import com.ntes_app.user.log_in.LogInFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstWindowFragment : Fragment() {
    private lateinit var binding: FragmentFirstWindowBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstWindowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button_spiice).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, OnboardingFragment())
                .commit()
        }
        view.findViewById<TextView>(R.id.go_to_login).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .commit()
        }
    }
}