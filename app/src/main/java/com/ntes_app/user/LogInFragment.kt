package com.ntes_app.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.databinding.FragmentLogInBinding
import com.ntes_app.ui.NavigationFragment

class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.returnToSignUpTextView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignUpFragment())
                .commit()
        }
        binding.buttonLogIn.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, NavigationFragment())
                .commit()
        }
    }

}