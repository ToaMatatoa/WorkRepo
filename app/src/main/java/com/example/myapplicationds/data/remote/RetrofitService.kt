package com.example.myapplicationds.data.remote

import com.example.myapplicationds.data.remote.model.ResponseData
import retrofit2.http.GET

interface RetrofitService {
    @GET("posts")
    suspend fun getAPIData(): List<ResponseData>
}