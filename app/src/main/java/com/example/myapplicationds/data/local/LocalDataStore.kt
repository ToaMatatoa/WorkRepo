package com.example.myapplicationds.data.local

import com.example.myapplicationds.data.local.model.LocalData

class LocalDataStore(private val localDataDao: LocalDataDao) {

    suspend fun getAllLocalData(): List<LocalData> = localDataDao.getAllLocalData()

    suspend fun saveLocaleData(localData: List<LocalData>) {
        localDataDao.saveAllLocalData(localData)
    }
}