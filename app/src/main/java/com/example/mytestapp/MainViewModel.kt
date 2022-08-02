package com.example.mytestapp

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : ViewModel() {

    val allBopaEntries: LiveData<List<BopaRoomEntry>>
    private val repository: BopaRepository
    val searchResults: MutableLiveData<List<BopaRoomEntry>>

    init {
        val bopaDb = AppDatabase.getDatabase(application)
        val bopaDao = bopaDb.bopaRoomDao()
        repository = BopaRepository(bopaDao)

        allBopaEntries = repository.allBopaEntries
        searchResults = repository.searchResults
    }


}