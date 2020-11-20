package com.example.myapplicationds.di

import androidx.room.Room
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
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

object DataModule {

    val dataModule = Kodein.Module("data module", false) {

        bind<RetrofitService>() with singleton {
            instance<Retrofit>().create(RetrofitService::class.java)
        }

        bind() from singleton { RemoteDataStore() }

        bind<RemoteRepository>() with singleton {
            RemoteRepository(
                remoteDataStore = instance()
            )
        }
        bind<DataUseCase>() with singleton {
            DataUseCase(
                remoteRepository = instance(), localRepository = instance()
            )
        }

        bind<RoomDB>() with singleton {
            Room.databaseBuilder(
                instance(),
                RoomDB::class.java, "items-name"
            ).build()
        }

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
    }
}