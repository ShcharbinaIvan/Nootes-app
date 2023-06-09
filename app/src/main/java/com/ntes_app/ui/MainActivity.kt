package com.ntes_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntes_app.R
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (sharedPreferenceRepository.firstOpenApp()) {
            supportFragmentManager.replaceFragment(R.id.container, FirstWindowFragment())
            sharedPreferenceRepository.setFirstOpenApp(false)
        } else {
            supportFragmentManager.replaceFragment(R.id.container, NavigationFragment())
        }
    }
}