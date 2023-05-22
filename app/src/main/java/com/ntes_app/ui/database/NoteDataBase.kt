package com.ntes_app.ui.database

import com.ntes_app.ui.adapter.Note
import com.ntes_app.ui.subscriber.Subscriber

object NoteDataBase {
    val listSubscribers = arrayListOf<Subscriber>()
    val list = arrayListOf<Note>()

    fun addNote(note: Note) {
        list.add(note)
        notifySubscribers()
    }

    fun deleteNote(actor: Note) {
        list.remove(actor)
        notifySubscribers()
    }

    fun getListNote() = list
    fun subscribe(s: Subscriber) {
        listSubscribers.add(s)
    }

    fun unsubscribe(s: Subscriber) {
        listSubscribers.remove(s)
    }

    private fun notifySubscribers() {
        listSubscribers.forEach {
            it.update()
        }
    }
}