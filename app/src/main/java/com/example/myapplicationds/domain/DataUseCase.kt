package com.example.myapplicationds.domain

import com.example.myapplicationds.data.local.LocalRepository
import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.RemoteRepository

class DataUseCase(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) {

    suspend fun getData(): List<LocalData> {
        return try {
            val remoteData = remoteRepository.getRemoteData()
            val localData = remoteData.map { it.toLocalData() }
            localRepository.saveLocalData(localData)

            localData
        } catch (e: Exception) {
            val localData = localRepository.getAllLocalData()

            localData
        }
    }
}