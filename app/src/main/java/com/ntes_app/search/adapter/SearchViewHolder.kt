package com.ntes_app.search.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ntes_app.databinding.ItemSearchBinding
import com.ntes_app.model.Note

class SearchViewHolder(private var binding: ItemSearchBinding) : ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.run{
            searchTextView.text = note.message
        }
    }
}