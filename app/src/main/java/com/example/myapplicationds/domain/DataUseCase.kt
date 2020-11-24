package com.example.myapplicationds.domain

import com.example.myapplicationds.data.local.LocalRepository
import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.RemoteRepository
import com.example.myapplicationds.data.remote.model.ResponseData
import java.time.LocalDate

class DataUseCase(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
)  {

    suspend fun getAllFromRemote(): List<ResponseData> = remoteRepository.getJsonData()

    suspend fun getAllFromDB(): List<LocalData> = localRepository.getAllLocalData()

//    suspend fun insertData(): List<LocalData> {
//        val a = map(input = ResponseData())
//    }
}