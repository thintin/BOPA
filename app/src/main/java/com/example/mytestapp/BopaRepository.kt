package com.example.mytestapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

class BopaRepository(private val bopaRoomDao: BopaRoomDao) {

    val allBopaRoomEntry: LiveData<List<BopaRoomEntry>> = bopaRoomDao.allBopaEntries()
    val searchResults = MutableLiveData<List<BopaRoomEntry>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertBopaEntry(newbopa: BopaRoomEntry) {
        coroutineScope.launch(Dispatchers.IO) {
            BopaRoomDao.insertBopaEntry(newbopa)
        }
    }

    fun deleteBopa(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            BopaRoomDao.deleteBopaEntry(name)
        }
    }

    fun findBopa(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    fun allBopas(): LiveData<List<BopaRoomEntry>> {
        return bopaRoomDao.allBopaEntries()
    }

    private fun asyncFind(name: String): Deferred<Flow<List<BopaRoomEntry>>> =
        coroutineScope.async(Dispatchers.IO) {
            return@async bopaRoomDao.findBopaEntry(name)
        }
}



