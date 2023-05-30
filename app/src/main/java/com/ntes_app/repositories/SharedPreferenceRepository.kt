package com.ntes_app.repositories

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val SHARED_PREFERENCE_FILE = "sharedPreferenceFile"
private const val FIRST_OPEN = "firstOpen"
private const val USER_EMAIL_PREFERENCE = "userEmailPreference"

object SharedPreferenceRepository {
    private var sharedPreferences: SharedPreferences? = null
    private var userEmailPreferences: SharedPreferences? = null

    fun initPreferences(context: Context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_FILE, Context.MODE_PRIVATE)
        userEmailPreferences = context.getSharedPreferences(USER_EMAIL_PREFERENCE, Context.MODE_PRIVATE)
    }

    fun setFirstOpenApp(firstOpen: Boolean) {
        sharedPreferences?.edit {
            putBoolean(FIRST_OPEN, firstOpen)
        }
    }

    fun firstOpenApp(): Boolean {
        return sharedPreferences?.getBoolean(FIRST_OPEN, true) ?: true
    }

    fun saveCurrentUserEmail(email: String) {
        userEmailPreferences?.edit {
            putString(USER_EMAIL_PREFERENCE, email)
        }
    }

    fun deleteCurrentUser() {
        userEmailPreferences?.edit {
            clear()
        }
    }
}