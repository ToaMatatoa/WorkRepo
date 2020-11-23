package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData

class RemoteRepository(private val remoteDataStore: RemoteDataStore) {

    suspend fun getJsonData(): List<ResponseData> {
        return remoteDataStore.getJsonData()
    }
}