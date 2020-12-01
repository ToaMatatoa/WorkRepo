package com.example.myapplicationds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationds.ui.FragmentShowRVData
import com.example.myapplicationds.ui.Navigation
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    private val parentKodein: Kodein by closestKodein()
    override val kodein: Kodein by retainedKodein {
        extend(parentKodein)
    }
    override val kodeinTrigger = KodeinTrigger()

    private val navigator: Navigation by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kodeinTrigger.trigger()
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            FragmentShowRVData()
        ).commit()
    }

    override fun onResume() {
        super.onResume()
        navigator.attach(activity = this)
    }
}