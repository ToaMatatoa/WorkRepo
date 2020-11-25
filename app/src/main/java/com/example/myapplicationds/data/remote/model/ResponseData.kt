package com.example.myapplicationds.data.remote.model

import com.google.gson.annotations.SerializedName

    data class ResponseData(
        @SerializedName("userID") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
    )