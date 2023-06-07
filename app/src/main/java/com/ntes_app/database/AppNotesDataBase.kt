package com.ntes_app.database

import android.content.Context
import androidx.room.Room
import com.ntes_app.database.note.NotesDao
import com.ntes_app.database.note.NotesDateBase
import com.ntes_app.database.user.UserDao
import com.ntes_app.database.user.UserDataBase
import com.ntes_app.model.Note
import com.ntes_app.model.User

object AppNotesDataBase {

    var userDao: UserDao? = null
    var notesDao: NotesDao? = null
    private var notesAppDataBase: NotesDateBase? = null
    private var userAppDataBase: UserDataBase? = null
    val listNotes = arrayListOf<Note>()
    val listUser = arrayListOf<User>()

    fun initDataBaseNotes(context: Context) {
        notesAppDataBase = Room.databaseBuilder(context, NotesDateBase::class.java, "notes-data-base").build()
        notesDao = notesAppDataBase?.getNotesDao()
    }

    fun initDataBaseUsers(context: Context) {
        userAppDataBase = Room.databaseBuilder(context, UserDataBase::class.java, "users-data-base").build()
        userDao = userAppDataBase?.getUserDao()
    }
}