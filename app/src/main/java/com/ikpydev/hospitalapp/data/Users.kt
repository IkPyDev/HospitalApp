package com.ikpydev.hospitalapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Users")
class Users(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "last")
    val last: String,
    @ColumnInfo(name = "date")
    val data: String,
    @ColumnInfo(name = "doctor_name")
    val doctor_name: String,
    @ColumnInfo(name = "doctor_last")
    val doctor_last: String,

    )