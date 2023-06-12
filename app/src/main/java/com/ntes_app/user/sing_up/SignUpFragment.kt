package com.ntes_app.user.sing_up

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ntes_app.R
import com.ntes_app.databinding.FragmentSignUpBinding
import com.ntes_app.model.User
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.ui.NavigationFragment
import com.ntes_app.user.log_in.LogInFragment
import com.ntes_app.util.getString
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: SingUpViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.goToLoginTextView.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .commit()
        }
        emailFocusListener()
        firstNameFocusListener()
        lastNameFocusListener()
        passwordFocusListener()
        binding.buttonSignUp.setOnClickListener {
            if (validate()) {
                addUser()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, NavigationFragment())
                    .commit()
            }
        }


    }

    private fun validate(): Boolean {

        binding.emailContainer.helperText = validateEmail()
        binding.firstNameContainer.helperText = validateFirstName()
        binding.lastNameContainer.helperText = validateLastName()
        binding.passwordContainer.helperText = validatePassword()

        val validFirstName = binding.firstNameContainer.helperText
        val validLastName = binding.lastNameContainer.helperText
        val validEmail = binding.emailContainer.helperText
        val validPassword = binding.passwordContainer.helperText
        if (validFirstName == null && validLastName == null && validEmail == null && validPassword == null) {
            return true
        }
        return false
    }

    private fun addUser() {

        val user = User(
            binding.firstNameEditText.getString(),
            binding.lastNameEditText.getString(),
            binding.emailEditText.getString(),
            binding.passwordEditText.getString()
        )
        viewModel.addNewUser(user)
        sharedPreferenceRepository.saveCurrentUserEmail(user.userEmail)
    }

    private fun emailFocusListener() {
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validateEmail()
            }
        }
    }

    private fun validateEmail(): String? {

        val emailText = binding.emailEditText.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "Invalid Email Address"
        }
//        if (emailText == viewModel.getUserEmail(emailText)) {
//            return "Email Already In Use"
//        }
        return null
    }

    private fun firstNameFocusListener() {
        binding.firstNameEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.firstNameContainer.helperText = validateFirstName()
            }
        }
    }

    private fun validateFirstName(): String? {

        val firstNameText = binding.firstNameEditText.text.toString()
        if (firstNameText.isEmpty()) {
            return "Invalid Name"
        }
        return null
    }

    private fun lastNameFocusListener() {
        binding.lastNameEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.lastNameContainer.helperText = validateLastName()
            }
        }
    }

    private fun validateLastName(): String? {

        val lastNameText = binding.lastNameEditText.text.toString()
        if (lastNameText.isEmpty()) {
            return "Invalid Name"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validatePassword()
            }
        }
    }

    private fun validatePassword(): String? {

        val passwordText = binding.passwordEditText.text.toString()
        if (passwordText.length < 8) {
            return "Minimum 8 Characters Password"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Must contain 1 Upper-case Character"
        }
        return null
    }

}