package com.ntes_app.user.log_in

import android.app.AlertDialog
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ntes_app.R
import com.ntes_app.databinding.FragmentLogInBinding
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.ui.NavigationFragment
import com.ntes_app.user.sing_up.SignUpFragment
import com.ntes_app.util.getString
import com.ntes_app.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LogInFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository
    private lateinit var binding: FragmentLogInBinding
    private val viewModel: LogInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        emailFocusListener()
        passwordFocusListener()
        binding.returnToSignUpTextView.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, SignUpFragment())
        }

        binding.buttonLogIn.setOnClickListener {
            if (validate()) {
                login()
            }


        }
    }

    private fun validate(): Boolean {
        binding.emailContainerLog.helperText = validateEmail()
        binding.passwordContainerLog.helperText = validatePassword()
        val validEmail = binding.emailContainerLog.helperText
        val validPassword = binding.passwordContainerLog.helperText
        if (validEmail == null && validPassword == null) {
            return true
        }
        return false
    }

    private fun login() {
        val email = binding.emailEditTextLog.getString()
        val password = binding.passwordEditTextLog.getString()
        viewModel.getUserEmail(email)
        var userPass = ""
        var userEmail = ""
        viewModel.emailUser.observe(viewLifecycleOwner) {
            userEmail = it
        }
        viewModel.passwordUser.observe(viewLifecycleOwner) {
            userPass = it
        }
        if (email == userEmail && password == userPass) {
            sharedPreferenceRepository.saveCurrentUserEmail(email)
            parentFragmentManager.replaceFragment(R.id.container, NavigationFragment())
        } else {
            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.invalid_password_or_email))
                .setPositiveButton(getString(R.string.ok)) { _, _ ->
                }
                .show()
        }
    }


    private fun validateEmail(): String? {
        val emailText = binding.emailEditTextLog.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
        return null
    }

    private fun emailFocusListener() {
        binding.emailEditTextLog.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainerLog.helperText = validateEmail()
            }
        }
    }

    private fun validatePassword(): String? {

        val passwordText = binding.passwordEditTextLog.text.toString()
        if (passwordText.length < 8) {
            return "Minimum 8 Characters Password"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must contain 1 Upper-case Character"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.passwordEditTextLog.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainerLog.helperText = validatePassword()
            }
        }
    }
}

