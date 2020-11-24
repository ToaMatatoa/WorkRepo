package com.example.myapplicationds.data.local

import com.example.myapplicationds.data.local.model.LocalData

class LocalDataStore (private val localDataDao: LocalDataDao) {

    suspend fun getAllLocalData() : List<LocalData> = localDataDao.getAll()
//
//    suspend fun getDataById() : List<LocalData> = localDataDao.getById()
//
//    suspend fun insertData() = localDataDao.insert()
//
//    suspend fun updateData() = localDataDao.update()
//
//    suspend fun deleteData() = localDataDao.delete()
}