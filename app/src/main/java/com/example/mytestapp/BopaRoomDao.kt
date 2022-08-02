package com.example.mytestapp

import androidx.room.*
//import java.util.concurrent.Flow
import kotlinx.coroutines.flow.Flow

@Dao
interface BopaRoomDao {

    //change entry on db
    @Update
    suspend fun updateBopa(bopaRoomEntry: BopaRoomEntry)

    //open list of previous entries from db
    @Query("SELECT * FROM bopa_table")
    fun findBopaEntry(name: String): Flow<List<BopaRoomEntry>>

    //add new entry to db
    @Insert
    suspend fun insertBopaEntry(bopaRoomEntry: List<BopaRoomEntry>)

    @Query("SELECT * FROM bopa_table")
    fun allBopaEntries(): Flow<List<BopaRoomEntry>>


}