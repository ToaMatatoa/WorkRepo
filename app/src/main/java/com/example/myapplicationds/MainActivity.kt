package com.example.myapplicationds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationds.ui.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.closestKodein

class MainActivity : AppCompatActivity(), KodeinAware {

    private val parentKodein: Kodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }
    override val kodeinTrigger: KodeinTrigger?
        get() = super.kodeinTrigger

    override fun onCreate(savedInstanceState: Bundle?) {
        kodeinTrigger?.trigger()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            Fragment()
        ).commit()
    }
}