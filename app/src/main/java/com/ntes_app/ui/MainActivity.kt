package com.ntes_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ntes_app.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, FirstWindowFragment())
            .commit()
    }
}