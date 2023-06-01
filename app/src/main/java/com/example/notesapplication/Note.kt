package com.example.notesapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
class Note (
    @ColumnInfo(name = "title")val noteTitle:String,
    @ColumnInfo(name = "description")val noteDescription:String,
    @ColumnInfo(name = "timeStamp")val noteTimeStamp:String
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}