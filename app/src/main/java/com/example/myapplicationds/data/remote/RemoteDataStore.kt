package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData
import io.reactivex.Single

class RemoteDataStore {

    private val retrofitService
            by lazy { RetrofitClient.getRemoteData() }

    fun getJsonData(): Single<List<ResponseData>> {
        return  retrofitService.getData() .map { it }
    }
}


