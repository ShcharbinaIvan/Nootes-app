package com.ntes_app.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ntes_app.R

class NotesViewHolder(private val view: View) : ViewHolder(view) {
    fun bind(note: Note) {
        val name: TextView = view.findViewById(R.id.name_text_view)
        val date: TextView = view.findViewById(R.id.date_text_view)
        val notes: TextView = view.findViewById(R.id.note_text_view)
        name.text = note.name
        date.text = note.date.toString()
        notes.text = note.note

    }
}