package com.example.mytestapp

import androidx.lifecycle.LiveData
import androidx.room.*
//import java.util.concurrent.Flow
import kotlinx.coroutines.flow.Flow

@Dao
interface BopaRoomDao {

    //add new entry to db
    @Insert
    fun insertBopa(bopaRoomEntry: BopaRoomEntry)

    //change entry on db
    @Update
    fun updateBopa(bopaRoomEntry: BopaRoomEntry)

    //open list of previous entries from db
    @Query("SELECT * FROM bopa_table")
    fun findBopa(name: String): Flow<List<BopaRoomEntry>>

    @Query("SELECT * FROM bopa_table")
    fun allBopas(): LiveData<List<BopaRoomEntry>>


}