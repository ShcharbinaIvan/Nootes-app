package com.ntes_app.onboarding_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.databinding.FragmentStepOnboardingBinding

const val STEP_1 = 1
const val STEP_2 = 2
const val STEP_3 = 3
private const val STEP_EXTRA = "stepExtra"

class StepOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentStepOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStepOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val step = arguments?.getInt(STEP_EXTRA) ?: STEP_1
        when (step) {
            STEP_1 -> {
                binding.secondText.setText(R.string.second_text)
                binding.textView1.setText(R.string.spiice)
                binding.imageView.setImageResource(R.drawable.planet)
            }

            STEP_2 -> {
                binding.secondText.setText(R.string.work_hard_and_level_up)
                binding.textView1.setText(R.string.spiice)
                binding.imageView.setImageResource(R.drawable.arrow_onboard)
            }

            STEP_3 -> {
                binding.secondText.setText(R.string.enjoy_your_progess)
                binding.textView1.setText(R.string.spiice)
                binding.imageView.setImageResource(R.drawable.smartphone)
            }
        }
    }

    companion object {

        fun getOnbordingStepFragment(stepNumber: Int): StepOnboardingFragment {
            return StepOnboardingFragment().apply {
                arguments = bundleOf(STEP_EXTRA to stepNumber)
            }
        }
    }

}
