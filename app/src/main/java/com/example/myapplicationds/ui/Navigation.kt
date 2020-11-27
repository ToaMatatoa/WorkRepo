package com.example.myapplicationds.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class Navigation {

    fun navigateToFragmentDetail() {
        val activity = AppCompatActivity()
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(com.example.myapplicationds.R.id.fragment_container, FragmentDetail())
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}