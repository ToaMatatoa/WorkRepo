package com.example.myapplicationds.ui

import androidx.fragment.app.FragmentTransaction
import com.example.myapplicationds.MainActivity
import java.lang.ref.WeakReference

class Navigation {

    private var activityRef = WeakReference<MainActivity>(null)
    private val activity: MainActivity?
        get() = activityRef.get()

    fun attach(activity: MainActivity){
        activityRef = WeakReference(activity)
    }

    fun navigateToFragmentDetail() {
        activity?.run {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(
                com.example.myapplicationds.R.id.fragment_container,
                FragmentDetail()
            )
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}