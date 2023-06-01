package com.ntes_app

import android.app.Application
import com.ntes_app.database.note.AppNotesDataBase
import com.ntes_app.repositories.SharedPreferenceRepository

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceRepository.initPreferences(applicationContext)
        AppNotesDataBase.initDataBase(applicationContext)
    }
}