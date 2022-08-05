package com.example.mytestapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : ViewModel() {

    val allBopas: LiveData<List<BopaRoomEntry>>
    private val repository: BopaRepository
    val searchResults: MutableLiveData<List<BopaRoomEntry>>

    init {
        val bopaDb = AppDatabase.getInstance(application)
        val bopaDao = bopaDb.bopaRoomDao()
        repository = BopaRepository(bopaDao)

        allBopas = repository.allBopaRoomEntry
        searchResults = repository.searchResults
    }

    fun insertBopa(bopaRoomEntry: BopaRoomEntry) {
        repository.insertBopaEntry(bopaRoomEntry)
    }

    fun findBopa(name: String) {
        repository.findBopa(name)
    }

    fun deleteBopa(name: String) {
        repository.deleteBopa(name)
    }


}