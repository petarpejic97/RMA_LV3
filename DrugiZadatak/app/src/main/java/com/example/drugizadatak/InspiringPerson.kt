package com.example.drugizadatak

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class InspiringPerson(
    @PrimaryKey val id : Int = 0,
    @ColumnInfo(name="image") val image : String,
    @ColumnInfo(name="fullName")val fullName : String,
    @ColumnInfo(name="birth")val birth : String,
    @ColumnInfo(name="descripton")val descripton : String,
    @ColumnInfo(name="statements")val statements : String){

    /*fun printInfo() : String{
        val length = statements.size-1
        val number= (0..length).random()
        return statements[number]
    }*/
}