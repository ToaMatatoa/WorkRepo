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
    suspend fun getAll(): List<LocalData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveData(localdata: List<LocalData>)
}