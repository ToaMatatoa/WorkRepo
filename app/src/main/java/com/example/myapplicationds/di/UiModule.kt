package com.example.myapplicationds.di

//import com.example.myapplicationds.data.local.RoomDB
import com.example.myapplicationds.ui.ViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.*

object UiModule {

    val uiModule = Kodein.Module("ui module", false) {

        bind<ViewModel>() with provider { ViewModel(itemsDataUseCase = instance()) }
    }
}