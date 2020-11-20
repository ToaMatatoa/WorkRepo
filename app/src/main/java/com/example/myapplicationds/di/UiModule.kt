package com.example.myapplicationds.di

//import com.example.myapplicationds.data.local.RoomDB
import com.example.myapplicationds.ui.IContract
import com.example.myapplicationds.ui.Presenter
import org.kodein.di.Kodein
import org.kodein.di.generic.*

object UiModule {

    val uiModule = Kodein.Module("ui module", false) {

        bind<IContract.IPresenter>() with provider { Presenter(itemsDataUseCase = instance()) }
        bind() from provider { Presenter(instance()) }
    }
}