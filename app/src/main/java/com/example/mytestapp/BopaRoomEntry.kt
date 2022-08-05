package com.example.mytestapp

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Constructor

@Entity (tableName = "BOPA_TABLE")
class BopaRoomEntry {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "bopaId")
    var id: Int = 0

    @ColumnInfo(name = "bopa_topic")
    var bopaTopic: String = ""

    @ColumnInfo(name = "bopa_content")
    var bopaContent: String = ""

    constructor(){}

    constructor(bopatopic: String, bopacontent: String) {
        //this.id = id
        this.bopaTopic = bopatopic
        this.bopaContent = bopacontent

    }
}

