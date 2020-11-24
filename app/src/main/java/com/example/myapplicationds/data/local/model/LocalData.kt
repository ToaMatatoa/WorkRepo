package com.example.myapplicationds.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplicationds.data.local.model.LocalData.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class LocalData(
    @PrimaryKey
    val id: Int,
    val title: String,
    val body: String
) {
    object Companion {
        const val TABLE_NAME = "localdata"
    }
}