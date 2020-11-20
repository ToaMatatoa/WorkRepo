package com.example.myapplicationds.data.local

import com.example.myapplicationds.data.local.model.LocalData

class LocalDataStore (private val localDataDao: LocalDataDao) {

    suspend fun getAllLocalData() : List<LocalData> = localDataDao.getAll()

    suspend fun getDataById() : List<LocalData> = localDataDao.getById(id = 0)

    suspend fun insertData() = localDataDao.insert(localdata = LocalData())

    suspend fun updateData() = localDataDao.update(localdata = LocalData())

    suspend fun deleteData() = localDataDao.delete(localdata = LocalData())
}