package com.example.myapplicationds.di

import androidx.fragment.app.Fragment
import com.example.myapplicationds.MainActivity
import com.example.myapplicationds.ui.Navigation
import com.example.myapplicationds.ui.ViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.*

object UiModule {

    val uiModule = Kodein.Module("ui module", false) {

        bind<ViewModel>() with provider { ViewModel(itemsDataUseCase = instance(), navigation = instance()) }

        bind<Navigation>() with provider { Navigation() }
    }
}