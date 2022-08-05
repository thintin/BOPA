package com.example.mytestapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(BopaRoomEntry::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bopaRoomDao(): BopaRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            synchronized(this) {
                var instance = INSTANCE

                if (INSTANCE == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "bopa-database.db"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}

