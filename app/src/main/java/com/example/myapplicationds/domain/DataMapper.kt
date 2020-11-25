package com.example.myapplicationds.domain

import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.model.ResponseData

fun ResponseData.toLocalData() = LocalData(
    id = id,
    title = title,
    body = body
)