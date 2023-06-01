package com.ntes_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntes_app.R
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.util.replaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (SharedPreferenceRepository.firstOpenApp()) {
            supportFragmentManager.replaceFragment(R.id.container, FirstWindowFragment())
            SharedPreferenceRepository.setFirstOpenApp(false)
        } else {
            supportFragmentManager.replaceFragment(R.id.container, NavigationFragment())
        }
    }
}