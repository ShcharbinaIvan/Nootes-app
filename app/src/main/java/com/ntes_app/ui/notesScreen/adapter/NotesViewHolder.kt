package com.ntes_app.ui.notesScreen.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ntes_app.databinding.ItemNotesBinding
import com.ntes_app.ui.model.Note

class NotesViewHolder(private val binding: ItemNotesBinding) : ViewHolder(binding.root) {
    fun bind(note: Note) {
        binding.run {
            nameTextView.text = note.name
            dateTextView.text = note.date.toString()
            messageTextView.text = note.message

        }

    }
}