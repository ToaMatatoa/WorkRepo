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
            val data = remoteRepository.getJsonData()
            val localData = data.map { it.toLocalData() }
            localRepository.saveData(localData)

            localData
        } catch (e: Exception) {
            val localData = localRepository.getAllLocalData()

            localData
        }
    }
}