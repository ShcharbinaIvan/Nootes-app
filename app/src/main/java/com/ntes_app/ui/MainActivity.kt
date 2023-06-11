package com.ntes_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntes_app.R
import com.ntes_app.repositories.SharedPreferenceRepository
import com.ntes_app.user.log_in.LogInFragment
import com.ntes_app.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (sharedPreferenceRepository.firstOpenApp()) {
            sharedPreferenceRepository.setFirstOpenApp(false)
            supportFragmentManager.replaceFragment(R.id.container, FirstWindowFragment())
        } else if (sharedPreferenceRepository.getCurrentUserEmail() != null) {
            supportFragmentManager.replaceFragment(R.id.container, NavigationFragment())
        } else if (sharedPreferenceRepository.getCurrentUserEmail() == null) {
            supportFragmentManager.replaceFragment(R.id.container, LogInFragment())
        }
    }
}