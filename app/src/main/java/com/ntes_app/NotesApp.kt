package com.ntes_app

import android.app.Application
import com.ntes_app.database.AppNotesDataBase
import com.ntes_app.repositories.SharedPreferenceRepository

class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceRepository.initPreferences(applicationContext)
        AppNotesDataBase.initDataBaseNotes(applicationContext)
        AppNotesDataBase.initDataBaseUsers(applicationContext)
    }
}