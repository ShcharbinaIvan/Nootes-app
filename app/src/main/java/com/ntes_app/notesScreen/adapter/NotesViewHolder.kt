package com.ntes_app.notesScreen.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ntes_app.databinding.ItemNotesBinding
import com.ntes_app.model.Note
import java.util.Date

class NotesViewHolder(private val binding: ItemNotesBinding) : ViewHolder(binding.root) {
    fun bind(note: Note) {
        binding.run {
            nameTextView.text = note.name
            dateTextView.text = Date(note.date).toString()
            messageTextView.text = note.message

        }

    }
}