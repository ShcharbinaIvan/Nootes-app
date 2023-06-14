package com.ntes_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.databinding.FragmentNavigationBinding
import com.ntes_app.notesAdd.AddNoteFragment
import com.ntes_app.notesScreen.NotesScreenFragment
import com.ntes_app.search.SearchFragment
import com.ntes_app.user.profile.ProfileFragment
import com.ntes_app.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class NavigationFragment : Fragment() {
    private lateinit var binding: FragmentNavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.beginTransaction().replace(R.id.container2, NotesScreenFragment())
            .commit()
        binding.bottomNavigationMenu
            .setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        parentFragmentManager.replaceFragment(
                            R.id.container2,
                            NotesScreenFragment(),
                            true
                        )
                        return@setOnItemSelectedListener true
                    }

                    R.id.search -> {
                        parentFragmentManager.replaceFragment(
                            R.id.container2,
                            SearchFragment(),
                            true
                        )
                        return@setOnItemSelectedListener true
                    }

                    R.id.add_note -> {
                        parentFragmentManager.replaceFragment(
                            R.id.container2,
                            AddNoteFragment(),
                            true
                        )
                        return@setOnItemSelectedListener true
                    }

                    R.id.profile -> {
                        parentFragmentManager.replaceFragment(
                            R.id.container2,
                            ProfileFragment(),
                            true
                        )
                        return@setOnItemSelectedListener true
                    }

                    else -> return@setOnItemSelectedListener true
                }
            }
    }
}
