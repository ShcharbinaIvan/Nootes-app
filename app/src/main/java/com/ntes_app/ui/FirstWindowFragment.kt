package com.ntes_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.ui.onboarding_fragments.FirstOnboardingFragment

class FirstWindowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_window, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.button_spiice).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FirstOnboardingFragment())
                .commit()
        }
        view.findViewById<TextView>(R.id.go_to_login).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesScreenFragment())
                .commit()
        }
    }
}