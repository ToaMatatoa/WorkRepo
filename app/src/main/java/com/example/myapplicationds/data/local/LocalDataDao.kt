package com.example.myapplicationds.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationds.data.local.model.LocalData

@Dao
interface LocalDataDao {

    @Query(
        "SELECT * FROM ${LocalData.Companion.TABLE_NAME}"
    )
    suspend fun getAllLocalData(): List<LocalData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllLocalData(localdata: List<LocalData>)
}