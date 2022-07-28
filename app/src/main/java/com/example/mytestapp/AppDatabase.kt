package com.example.mytestapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BopaRoomEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bopaRoomDao() : BopaRoomDao

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
        ).build()

//    val bopaRoomDao = db.bopaRoomDao()
//    val bopaRoomEntrys: List<BopaRoomEntry> = bopaRoomDao.getAll()
    }
