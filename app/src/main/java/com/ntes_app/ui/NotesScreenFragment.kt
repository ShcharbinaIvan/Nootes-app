package com.ntes_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ntes_app.R
import com.ntes_app.ui.adapter.NotesAdapter
import com.ntes_app.ui.database.NoteDataBase
import com.ntes_app.ui.subscriber.Subscriber

class NotesScreenFragment : Fragment(), Subscriber {
    private var recyclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notes_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.add_new_note).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddNoteFragment())
                .commit()
        }
        view.findViewById<TextView>(R.id.logout_text_view).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .commit()
        }
        NoteDataBase.subscribe(this)
        recyclerView = view.findViewById<RecyclerView>(R.id.note_recycler_view)
        recyclerView?.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = NotesAdapter()
            (adapter as? NotesAdapter)?.setList(
                NoteDataBase.getListNote()
            )
        }
    }

    override fun update() {
        recyclerView?.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = NotesAdapter()
            }
            (adapter as? NotesAdapter)?.setList(
                NoteDataBase.getListNote()
            )
            adapter?.notifyDataSetChanged()
        }
    }
}

