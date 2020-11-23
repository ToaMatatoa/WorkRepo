package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData

class RemoteDataStore {

    private val retrofitService
            by lazy { RetrofitClient.getRemoteData() }

    suspend fun getJsonData(): List<ResponseData> {
        return  retrofitService.getData() .map { it }
    }
}


