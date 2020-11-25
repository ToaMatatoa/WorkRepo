package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData

class RemoteDataStore {

    private val retrofitService
            by lazy { RetrofitClient.getRemoteData() }

    suspend fun getRemoteData(): List<ResponseData> {
        return  retrofitService.getAPIData()
    }
}


