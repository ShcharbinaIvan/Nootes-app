package com.ntes_app.user

import android.os.Bundle
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
import com.ntes_app.util.getString
import com.ntes_app.validation.ValidationResult
import com.ntes_app.validation.userFirstNameValidation

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: UserViewModel by viewModels()
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
        binding.buttonSignUp.setOnClickListener {
            if (validateFirstName()) {
                addUser()

                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, NavigationFragment())
                    .commit()
            }
        }

    }

    private fun addUser() {
        val user = User(
            binding.firstNameEditText.getString(),
            binding.lastNameEditText.getString(),
            binding.editTextTextEmailAddress.getString(),
            binding.editTextTextPassword.getString()
        )
        viewModel.addNewUser(user)
    }

    private fun validateFirstName(): Boolean {
        val firstNameValidationResult = userFirstNameValidation(binding.firstNameEditText.getString())
        when (firstNameValidationResult) {
            is ValidationResult.Invalid -> binding.firstNameEditText.error =
                requireContext().getString(firstNameValidationResult.errorId)

            else -> binding.firstNameEditText.error = null
        }
        return firstNameValidationResult == ValidationResult.Valid
    }
}