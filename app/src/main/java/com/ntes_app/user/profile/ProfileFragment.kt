package com.ntes_app.user.profile

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ntes_app.R
import com.ntes_app.databinding.FragmentProfileBinding
import com.ntes_app.onboarding_fragments.OnboardingFragment
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.user.log_in.LogInFragment
import com.ntes_app.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class ProfileFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserName()
        viewModel.getAllNotesQuantity()
        viewModel.notesQuantity.observe(viewLifecycleOwner) {
            binding.notesQuantity.text = it.toString()
        }
        viewModel.userName.observe(viewLifecycleOwner) {
            binding.profileName.text = it
        }
        binding.deleteProfileButton.setOnClickListener {
            deleteProfile()
        }
        binding.logoutTexView.setOnClickListener {
            logOut()
        }
        binding.deleteAllNotesButton.setOnClickListener {
            deleteAllNotes()
        }

    }

    private fun deleteAllNotes() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.delete_all_notes_2))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.deleteNotes()
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->

            }
            .show()

    }

    private fun logOut() {
        sharedPreferenceRepository.deleteCurrentUser()
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, LogInFragment())
            .commit()
    }

    private fun deleteProfile() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.delete_current_use))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.deleteUser()
                viewModel.deleteNotes()
                sharedPreferenceRepository.deleteCurrentUser()
                parentFragmentManager.replaceFragment(R.id.container, LogInFragment())
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->

            }
            .show()
    }

    companion object {
        const val TAG = "ProfileFragment"
    }
}