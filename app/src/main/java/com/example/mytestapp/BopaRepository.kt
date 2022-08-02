package com.example.mytestapp

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

class BopaRepository(private val bopaRoomDao: BopaRoomDao) {
    val searchResults = MutableLiveData<List<BopaRoomEntry>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertBopaEntry(newbopa: BopaRoomEntry) {
        coroutineScope.launch(Dispatchers.IO) {
            BopaRoomDao.insertBopaEntry(newbopa)
        }
    }

    fun deleteBopaEntry(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            bopaRoomDao.deleteBopaEntry(name)
        }
    }

    fun findBopaEntry(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    fun allBopaEntries(): Flow<List<BopaRoomEntry>> {
        return bopaRoomDao.allBopaEntries()
    }

    private fun asyncFind(name: String): Deferred<List<BopaRoomEntry>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async bopaRoomDao.findBopaEntry(name)
        }

}



