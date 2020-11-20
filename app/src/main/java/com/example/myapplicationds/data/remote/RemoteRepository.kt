package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData
import io.reactivex.Single

class RemoteRepository(private val remoteDataStore: RemoteDataStore) {

    fun getJsonData(): Single<List<ResponseData>> {
        return remoteDataStore.getJsonData()
    }
}