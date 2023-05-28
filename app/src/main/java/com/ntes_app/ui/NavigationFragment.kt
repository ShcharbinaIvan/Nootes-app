package com.ntes_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ntes_app.R
import com.ntes_app.ui.notesAdd.AddNoteFragment
import com.ntes_app.ui.notesScreen.NotesScreenFragment
import com.ntes_app.ui.util.replaceFragment

class NavigationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        parentFragmentManager.beginTransaction().replace(R.id.container2, NotesScreenFragment())
            .commit()
        view.findViewById<BottomNavigationView>(R.id.bottom_navigation_menu)
            .setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        parentFragmentManager.replaceFragment(R.id.container2, NotesScreenFragment(),true)
                        return@setOnItemSelectedListener true
                    }

                    R.id.search -> {
                        parentFragmentManager.replaceFragment(R.id.container2, SearchFragment(),true)
                        return@setOnItemSelectedListener true
                    }

                    R.id.add_note -> {
                        parentFragmentManager.replaceFragment(R.id.container2, AddNoteFragment(),true)
                        return@setOnItemSelectedListener true
                    }

                    R.id.profile -> {
                        parentFragmentManager.replaceFragment(R.id.container2, ProfileFragment(),true)
                        return@setOnItemSelectedListener true
                    }

                    else -> return@setOnItemSelectedListener true
                }
            }
    }
}
