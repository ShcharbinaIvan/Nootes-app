package com.ntes_app.onboarding_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.databinding.FragmentOnboardingBinding
import com.ntes_app.user.sing_up.SignUpFragment
import com.ntes_app.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.skip_first).setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, SignUpFragment())
        }
        binding.viewPager.adapter = OnboardingAdapter(parentFragmentManager)
        binding.circleIndicator.setViewPager(binding.viewPager)
    }
}