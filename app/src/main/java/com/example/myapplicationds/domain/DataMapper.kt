package com.example.myapplicationds.domain

import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.model.ResponseData
import com.example.myapplicationds.domain.model.DomainData

fun ResponseData.toLocalData() = LocalData(
    id = id,
    title = title,
    body = body
)

//fun ResponseData.toDomainData() = DomainData(
//    id = id,
//    title = title,
//    body = body
//)