package com.example.drugizadatak

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDao{
    @Insert
    fun insert(person: InspiringPerson);

    @Delete
    fun delete(person: InspiringPerson);

    @Query("SELECT * FROM persons")
    fun getAll(): List<InspiringPerson>;

    @Query("SELECT * FROM persons WHERE id = :id")
    fun getById(id: Int): InspiringPerson

    @Query("SELECT MAX(id) FROM persons")
    fun getMaxId():Int
}