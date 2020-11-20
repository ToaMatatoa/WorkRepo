package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitService {
    @GET("posts")
    fun getData(): Single<List<ResponseData>>
}