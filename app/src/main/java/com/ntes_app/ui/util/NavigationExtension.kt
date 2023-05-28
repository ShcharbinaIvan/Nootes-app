package com.ntes_app.ui.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(
    idContainer: Int, fragment: Fragment, addToBackStack: Boolean = false
) {
    if (addToBackStack) {
        beginTransaction().replace(idContainer, fragment).addToBackStack("").commit()
    } else {
        beginTransaction().replace(idContainer, fragment).commit()
    }
}
