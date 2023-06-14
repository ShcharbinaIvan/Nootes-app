package com.ntes_app.onboarding_fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ntes_app.onboarding_fragments.StepOnboardingFragment.Companion.getOnbordingStepFragment

class OnboardingAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val listFragment =
        arrayListOf(
            getOnbordingStepFragment(STEP_1),
            getOnbordingStepFragment(STEP_2),
            getOnbordingStepFragment(STEP_3)
        )

    override fun getCount() = listFragment.size

    override fun getItem(position: Int): Fragment = listFragment[position]

}