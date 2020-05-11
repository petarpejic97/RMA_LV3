package com.example.drugizadatak

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = arrayOf(InspiringPerson::class))
abstract class PersonDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    companion object {
        private const val NAME = "book_database"
        private var INSTANCE: PersonDatabase? = null
        fun getInstance(): PersonDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    DrugiZadatak.ApplicationContext,
                    PersonDatabase::class.java,
                    NAME)
                    .allowMainThreadQueries() // Not for real apps!
                    .build()
            }
            return INSTANCE as PersonDatabase
        }
    }
}