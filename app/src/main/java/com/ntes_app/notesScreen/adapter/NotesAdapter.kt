package com.ntes_app.notesScreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ntes_app.databinding.ItemNotesBinding
import com.ntes_app.model.Note

class NotesAdapter(
    private var onClick: (note: Note, itemView: View) -> Unit
) : ListAdapter<Note, NotesViewHolder>(
    object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return false
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return false
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.imageView.setOnClickListener {
            onClick(getItem(position), it)
        }
    }

}