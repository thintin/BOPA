package com.example.mytestapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import java.net.ContentHandler

@Dao
interface BopaRoomDao {
    @Insert
    fun insertBopaEntry(vararg bopaRoomEntrys: BopaRoomEntry)
}