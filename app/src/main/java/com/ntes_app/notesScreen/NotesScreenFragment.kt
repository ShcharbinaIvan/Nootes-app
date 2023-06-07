package com.ntes_app.notesScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ntes_app.databinding.FragmentNotesScreenBinding
import com.ntes_app.model.Note
import com.ntes_app.notesScreen.adapter.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesScreenFragment : Fragment() {
    private lateinit var binding: FragmentNotesScreenBinding
    private val viewModel: NotesScreenViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotesScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.notesList.observe(viewLifecycleOwner) {
            setListNotes(it)
        }
        viewModel.getAllNotes()
    }

    private fun setListNotes(list: ArrayList<Note>) {
        binding.noteRecyclerView.run {
            if (adapter == null) {
                adapter = NotesAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? NotesAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }

    companion object {
        const val TAG = "NotesScreenFragment"
    }
}

