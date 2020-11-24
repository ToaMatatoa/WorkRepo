package com.example.myapplicationds.di

import android.app.Application
import androidx.room.Room
import com.example.myapplicationds.data.local.LocalDataDao
import com.example.myapplicationds.data.local.LocalDataStore
import com.example.myapplicationds.data.local.LocalRepository
import com.example.myapplicationds.data.local.RoomDB
import com.example.myapplicationds.data.remote.RemoteDataStore
import com.example.myapplicationds.data.remote.RemoteRepository
import com.example.myapplicationds.data.remote.RetrofitService
import com.example.myapplicationds.domain.DataUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

object DataModule : Application() {

    val dataModule = Kodein.Module("data module", false) {

        //Remote
        bind<RetrofitService>() with singleton {
            instance<Retrofit>().create(RetrofitService::class.java)
        }

        bind() from singleton { RemoteDataStore() }

        bind<RemoteRepository>() with singleton {
            RemoteRepository(
                remoteDataStore = instance()
            )
        }

        //Local
        bind<RoomDB>() with singleton {
            Room.databaseBuilder(
                instance(),
                RoomDB::class.java, "items-name"
            ).build()
        }

        bind<LocalDataDao>() with provider { instance<RoomDB>().dataDao() }

        bind<LocalDataStore>() with singleton {
            LocalDataStore(
                localDataDao = instance()
            )
        }

        bind<LocalRepository>() with singleton {
            LocalRepository(
                localDataStore = instance()
            )
        }

        //UseCase
        bind<DataUseCase>() with singleton {
            DataUseCase(
                remoteRepository = instance(),
                localRepository = instance()
            )
        }


    }
}