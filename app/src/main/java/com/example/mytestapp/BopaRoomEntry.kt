package com.example.mytestapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity (tableName = "BOPA_TABLE")
data class BopaRoomEntry(
    @PrimaryKey val bopaId: Int,
    @ColumnInfo(name = "bopa_topic") val bopaTopic: String?,
    @ColumnInfo(name = "bopa_content") val bopaContent: String?)

