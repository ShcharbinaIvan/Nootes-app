package com.ntes_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ntes_app.R

class NotesAdapter : RecyclerView.Adapter<NotesViewHolder>() {
    private var list = arrayListOf<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
    fun setList(list: ArrayList<Note>) {
        this.list = list
        notifyDataSetChanged()
    }
}