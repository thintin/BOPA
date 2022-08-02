package com.example.mytestapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BopaRoomEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bopaRoomDao(): BopaRoomDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "bopa-database.db"
                    ).build()
                }
            }

            return INSTANCE!!
        }
    }
}

