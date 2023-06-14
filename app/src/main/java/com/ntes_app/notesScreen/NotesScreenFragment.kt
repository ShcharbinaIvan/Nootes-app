package com.ntes_app.notesScreen

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ntes_app.R
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
                adapter = NotesAdapter { note, view ->
                    showPopup(view, note)
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? NotesAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun showPopup(v: View, note: Note) {
        val popup = PopupMenu(requireContext(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_notes, popup.menu)
        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.delete -> {
                    showDeleteDialog(note)
                }
            }
            return@setOnMenuItemClickListener true
        }
        popup.show()
    }

    private fun showDeleteDialog(note: Note) {

        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.delete_note))
            .setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.deleteNote(note)
            }
            .setNegativeButton(getString(R.string.no)) { _, _ ->

            }
            .show()
    }

    companion object {
        const val TAG = "NotesScreenFragment"
    }
}

