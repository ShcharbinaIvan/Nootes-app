package com.ntes_app.ui

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ntes_app.R
import com.ntes_app.ui.database.NoteDataBase
import java.util.Date


class AddNoteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.back_text_view).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, NotesScreenFragment())
                .commit()
        }
        val noteNameLayout = view.findViewById<EditText>(R.id.title1_edit_text)
        val noteMessageLayout = view.findViewById<EditText>(R.id.message_edit_text)
        view.findViewById<Button>(R.id.button_add).setOnClickListener {
            val name: String = noteNameLayout.text.toString()
            val message: String = noteMessageLayout.text.toString()
            val currentDate = Date() // Текущая дата
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val formattedDate: String = sdf.format(currentDate)
            val note = com.ntes_app.ui.adapter.Note(name, formattedDate, message)
            NoteDataBase.addNote(note)
            Toast.makeText(requireContext(), "Note saved", Toast.LENGTH_LONG).show()
            parentFragmentManager.popBackStack()

        }


    }
}