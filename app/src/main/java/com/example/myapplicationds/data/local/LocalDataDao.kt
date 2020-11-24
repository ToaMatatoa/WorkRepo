package com.example.myapplicationds.data.local

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplicationds.data.local.model.LocalData

@Dao
interface LocalDataDao {

    @Query(
        "SELECT * FROM ${LocalData.Companion.TABLE_NAME}"
    )
    suspend fun getAll(): List<LocalData>

//    @Insert
//    suspend fun insert(localdata: LocalData)
}