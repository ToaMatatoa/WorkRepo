package com.example.myapplicationds.data.local

import com.example.myapplicationds.data.local.model.LocalData

class LocalRepository(private val localDataStore: LocalDataStore) {

    suspend fun getAllLocalData(): List<LocalData> = localDataStore.getAllLocalData()

    suspend fun saveData(localData: List<LocalData>) {
        localDataStore.saveLocaleData(localData)
    }
}