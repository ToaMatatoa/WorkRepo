package com.example.myapplicationds.data.local

import androidx.room.*
import com.example.myapplicationds.data.local.model.LocalData

@Dao
interface LocalDataDao {

    @Query("SELECT * FROM localdata")
    suspend fun getAll(): List<LocalData>

    @Query("SELECT * FROM localdata WHERE id = :id")
    suspend fun getById(id: Int): List<LocalData>

    @Insert
    suspend fun insert(localdata: LocalData)

    @Update
    suspend fun update(localdata: LocalData)

    @Delete
    suspend fun delete(localdata: LocalData)
}