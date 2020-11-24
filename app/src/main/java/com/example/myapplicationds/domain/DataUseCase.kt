package com.example.myapplicationds.domain

import com.example.myapplicationds.data.local.LocalRepository
import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.RemoteRepository
import com.example.myapplicationds.data.remote.model.ResponseData

class DataUseCase(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {

    suspend fun getAllFromRemote(): List<ResponseData> = remoteRepository.getJsonData()

    suspend fun getAllFromDB(): List<LocalData> = localRepository.getAllLocalData()

//    suspend fun getDataById(): List<LocalData> = localRepository.getDataById()
//
//    suspend fun insertData(): List<LocalDate> {
//        val remoteData = remoteRepository.getJsonData()
//
//    }
//
//    suspend fun updateData() = localRepository.updateData()
//
//    suspend fun deleteData() = localRepository.deleteData()
}