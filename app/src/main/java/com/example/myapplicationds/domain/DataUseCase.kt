package com.example.myapplicationds.domain

//import com.example.myapplicationds.data.local.LocalRepository
//import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.RemoteRepository
import com.example.myapplicationds.data.remote.model.ResponseData
import io.reactivex.Single

class DataUseCase(
    private val remoteRepository: RemoteRepository
   //private val localRepository: LocalRepository
) {

    suspend fun getItemsData(): List<ResponseData> = remoteRepository.getJsonData()

  //  suspend fun getAll() : List<LocalData> = localRepository.getAllLocalData()

//    suspend fun getDataById() : List<LocalData> = localRepository.getDataById()

 //   suspend fun insertData() {}

//    suspend fun updateData() = localRepository.updateData()

//    suspend fun deleteData() = localRepository.deleteData()
}