package com.ntes_app.notesScreen.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ntes_app.databinding.ItemNotesBinding
import com.ntes_app.model.Note
import java.text.SimpleDateFormat
import java.util.Date

class NotesViewHolder(private val binding: ItemNotesBinding) : ViewHolder(binding.root) {

    private val format = SimpleDateFormat(" dd/MM/yyyy")
    val imageView = binding.toDoImageView


    fun bind(note: Note) {
        binding.run {
            nameTextView.text = note.name
            dateTextView.text = format.format(Date(note.date)).toString()
            messageTextView.text = note.message

        }

    }
}